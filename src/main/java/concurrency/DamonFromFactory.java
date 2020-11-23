package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * concurrence
 *
 * @author plusman
 * @since 2020/11/21
 */
public class DamonFromFactory implements Runnable {

    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + "  " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread() + " " + this + " end");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DamonThreadFactory());
        for (int i = 0; i < 5; i++) {
            exec.execute(new DamonFromFactory());
        }
        System.out.println("All Damons started");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
