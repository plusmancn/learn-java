package concurrency;

/**
 * concurrency
 *
 * @author plusman
 * @since 11/22/20
 */
public class Atomicity {
    int i;
    void f1() {i++;}
    void f2() {i += 3;}
}
