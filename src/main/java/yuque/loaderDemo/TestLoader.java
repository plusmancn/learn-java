package yuque.loaderDemo;

/**
 * yuque.loaderDemo
 *
 * @author plusman
 * @since 2020/11/2
 */
public class TestLoader extends ClassLoader{
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}
