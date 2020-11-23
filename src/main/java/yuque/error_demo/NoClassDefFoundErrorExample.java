package yuque.error_demo;

/**
 * yuque.error_demo
 *
 * @author plusman
 * @since 2020/11/8
 */
public class NoClassDefFoundErrorExample {
    public static void main(String[] args) {
        NoClassDefFoundErrorExample sample
            = new NoClassDefFoundErrorExample();
        sample.getClassWithInitErrors();
    }

    public ClassWithInitErrors getClassWithInitErrors() {
        ClassWithInitErrors test;
        try {
            test = new ClassWithInitErrors();
        } catch (Throwable t) {
            System.out.println(t);
            t.printStackTrace();
        }
        test = new ClassWithInitErrors();
        return test;
    }
}

class ClassWithInitErrors {
    static int data = 1 / 0;
    public static void xxx() {

    }

    public void tt(){}
}
