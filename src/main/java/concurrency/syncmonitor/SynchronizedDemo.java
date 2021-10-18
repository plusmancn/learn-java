package concurrency.syncmonitor;

/**
 * @author plusman
 * @since 2021/10/17 6:31 PM
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
