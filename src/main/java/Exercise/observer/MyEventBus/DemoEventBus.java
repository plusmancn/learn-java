package Exercise.observer.MyEventBus;

import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * 参数类型
 */
class XMsg { }
class YMsg extends XMsg {}
class ZMsg {}

class AObserver {
    @Subscribe
    @com.google.common.eventbus.Subscribe
    public void f(XMsg event){
        System.out.println(this.getClass().getName() + event.getClass().getName());
    }
}
class BObserver {
    @Subscribe
    @com.google.common.eventbus.Subscribe
    public void f1(YMsg event) {
        System.out.println(this.getClass().getName() + event.getClass().getName());
    }
    @Subscribe
    @com.google.common.eventbus.Subscribe
    public void f2(ZMsg event) {
        System.out.println(this.getClass().getName() + event.getClass().getName());
    }
}
class CObserver {
    @Subscribe
    @com.google.common.eventbus.Subscribe
    public void f3(ZMsg event) {
        System.out.println(this.getClass().getName() + event.getClass().getName());
    }
}

public class DemoEventBus {
    private MyEventBus eventBus;
    // private EventBus eventBus;

    public DemoEventBus() {
        // eventBus = new EventBus();
        eventBus = new MyEventBus();
        // this.eventBus = new MyAsyncEventBus(Executors.newFixedThreadPool(5));
    }

    public void post(Object event) {
        System.out.println("post: " + event.getClass().getName());
        eventBus.post(event);
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public static void main(String[] args) {
        DemoEventBus demo = new DemoEventBus();
        List<Object> observers = new ArrayList<>();
        observers.add(new AObserver());
        observers.add(new BObserver());
        observers.add(new CObserver());

        demo.setRegObservers(observers);

        demo.post(new XMsg());
        demo.post(new YMsg());
        demo.post(new ZMsg());
    }
}
