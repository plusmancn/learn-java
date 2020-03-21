package Exercise.observer;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;

class UserService {
    Long register(String telephone, String password) {
        return Long.valueOf(10);
    }
}


class RegPromotionObserver {
    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println("REG: " + userId);
    }
}


public class UserController {
    private UserService userService = new UserService();
    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController() {
        // 异步非阻塞
        // eventBus = new EventBus();
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password) {
        Long userId = userService.register(telephone, password);

        eventBus.post(userId);

        return userId;
    }

    public static void main(String[] args) {
        UserController userController = new UserController();
        List<Object> observers = new LinkedList<>();
        observers.add(new RegPromotionObserver());
        userController.setRegObservers(observers);

        userController.register("17681878834", "nopassword");
    }
}
