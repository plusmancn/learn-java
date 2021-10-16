package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * concurrency
 *
 * @author plusman
 * @since 12/3/20
 */
public class LockTest {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionLock = lock.newCondition();

    private void method1() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println("method1 enter");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("method1 finish");
        } finally {
            lock.unlock();
        }
    }

    private void method2() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println("method2 enter");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("method2 finish");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        lockTest.method1();
        lockTest.method2();
    }

}
