package Exercise.classdemo;

/**
 * Exercise.classdemo
 *
 * @author plusman
 * @since 2020/11/18
 */
public class Demo {
    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.callProtectedMethod();
    }
}

class Foo {
    private final void protectedMethod() {
        System.out.println("protected method");
    }
}

class Bar extends Foo {
    void callProtectedMethod() {
        this.protectedMethod();
    }

    protected void protectedMethod() {
        System.out.println("foo");
    }

    private void privateMethod() {

    }
}
