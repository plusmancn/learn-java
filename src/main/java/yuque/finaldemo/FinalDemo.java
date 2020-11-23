package yuque.finaldemo;

/**
 * yuque
 *
 * @author plusman
 * @since 2020/11/1
 */
public class FinalDemo {
    public static void main(String[] args) {
        FinalDemo finalDemo = new FinalDemo();
    }

    private void testPrivate(){
    }

    public void testPublic() {
    }

    final public void testFinal() {

    }
}

class OverriddenFinalDemo extends FinalDemo {
    @Override
    public void testPublic() {
        super.testPublic();
    }
}

