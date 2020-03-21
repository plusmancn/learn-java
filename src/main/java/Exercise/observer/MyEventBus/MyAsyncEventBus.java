package Exercise.observer.MyEventBus;

import java.util.concurrent.Executor;

public class MyAsyncEventBus extends  MyEventBus{
    public MyAsyncEventBus(Executor executor) {
        super(executor);
    }
}
