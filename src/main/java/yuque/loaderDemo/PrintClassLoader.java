package yuque.loaderDemo;

import com.sun.javafx.util.Logging;

import java.util.ArrayList;

/**
 * yuque.loaderDemo
 *
 * @author plusman
 * @since 2020/11/2
 */
public class PrintClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        PrintClassLoader printClassLoader = new PrintClassLoader();
        printClassLoader.printClassLoaders();
    }

    public void printClassLoaders() throws ClassNotFoundException {
        System.out.println("Classloader of this class:" + PrintClassLoader.class.getClassLoader());
        System.out.println("Classloader of Logging:" + Logging.class.getClassLoader());
        System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());

        Class.forName("cn.xx.sample");
    }
}
