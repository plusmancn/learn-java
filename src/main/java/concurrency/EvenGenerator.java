package concurrency;

/**
 * concurrency
 *
 * @author plusman
 * @since 2020/11/21
 */
public class EvenGenerator extends IntGenerator {
    private volatile int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
