package Exercise.Stream;

/**
 * Exercise.Stream
 *
 * @author plusman
 * @since 2020/9/18
 */
@FunctionalInterface
public interface ToXx<T> {

    int applyTo(T value);
}
