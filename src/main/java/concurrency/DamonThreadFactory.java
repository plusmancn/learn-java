package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * concurrence
 *
 * @author plusman
 * @since 2020/11/21
 */
public class DamonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}

