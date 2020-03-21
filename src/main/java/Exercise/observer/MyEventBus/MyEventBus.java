package Exercise.observer.MyEventBus;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/**
 * 框架实现
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Beta
@interface Subscribe {}

class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }
}

class ObserverRegistry {
    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();

            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);

            if (registeredEventActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }

            registeredEventActions.addAll(eventActions);
        }
    }

    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();

        Class<?> postedEventType = event.getClass();

        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            if (eventType.isAssignableFrom(postedEventType)) {
                matchedObservers.addAll(eventActions);
            }
        }

        return matchedObservers;
    }



    /**
     * 事件路由表
     * @param observer
     * @return
     */
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey((eventType))) {
                observerActions.put(eventType, new ArrayList<>());
            }

            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }

        return observerActions;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters"
                + "Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}

/**
 * EventBus 开放类
 */
public class MyEventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public MyEventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected MyEventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        registry.register(object);
    }

    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
