package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * concurrence
 * wait/notify 版本，由 JVM 保障输出一致性
 * @author plusman
 * @since 2020/11/21
 */

class Counter {
    public int max;
    public volatile int i = 0;

    public Counter(int max) {
        this.max = max;
    }
}

class PrinterThread implements Runnable {
    private String name;
    private Counter counter;

    public PrinterThread(String name, Counter counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            while (counter.i < counter.max) {
                System.out.println(name + " print: " + (counter.i++));
                counter.notify();

                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    System.out.println(name + " was interrupted");
                }
            }
        }
    }
}


public class AlternateOutputDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(20);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new PrinterThread("P1", counter));
        exec.execute(new PrinterThread("P2", counter));
        exec.shutdown();

        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}