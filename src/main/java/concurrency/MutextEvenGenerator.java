package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * concurrency
 *
 * @author plusman
 * @since 2020/11/21
 */
public class MutextEvenGenerator extends IntGenerator {
    private int currentValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentValue;
            ++currentValue;
            return currentValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutextEvenGenerator());
    }
}
