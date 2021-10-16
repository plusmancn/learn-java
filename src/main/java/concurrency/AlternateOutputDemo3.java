package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * concurrence
 *
 * 如果是 3 个线程交替输出呢？0。0
 * @author plusman
 * @since 2020/11/21
 */

class MultipleCounter extends Counter {
    public enum PRINTER_NAME {
        P1,
        P2,
        P3
    };

    private List<PRINTER_NAME> printerOrder;
    private int cursor = 0;

    public MultipleCounter(int max, List<PRINTER_NAME> printerOrder) {
        super(max);
        this.printerOrder = printerOrder;
    }

    /**
     * 获取当前状态，移动指针到下一个状态
     */
    public PRINTER_NAME getCurrentState() {
        return printerOrder.get(cursor % printerOrder.size());
    }

    public void nextState() {
        cursor++;
    }
}

class MultiplePrinter implements Runnable {
    private String name;
    private MultipleCounter counter;

    public MultiplePrinter(String name, MultipleCounter counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            while (counter.i < counter.max) {
                if (counter.getCurrentState().name().equals(name)) {
                    System.out.println(name + " print: " + (counter.i++));
                    counter.nextState();
                    counter.notifyAll();
                }

                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    System.out.println(name + " was interrupted");
                }
            }
        }
    }
}




/**
 * @author plusman
 */
public class AlternateOutputDemo3 {
    public static void main(String[] args) throws InterruptedException {
        List<MultipleCounter.PRINTER_NAME> printerOrder = new ArrayList<>();
        printerOrder.add(MultipleCounter.PRINTER_NAME.P1);
        printerOrder.add(MultipleCounter.PRINTER_NAME.P2);
        printerOrder.add(MultipleCounter.PRINTER_NAME.P3);

        MultipleCounter counter = new MultipleCounter(20, printerOrder);
        ExecutorService exec = Executors.newCachedThreadPool();
        printerOrder.forEach(printerName -> exec.execute(new MultiplePrinter(printerName.name(), counter)));

        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}