package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * concurrence
 *
 * @author plusman
 * @since 2020/11/20
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }

        executorService.shutdown();
        executorService.execute(new LiftOff());
    }
}
