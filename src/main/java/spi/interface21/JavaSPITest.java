package spi.interface21;

import java.util.ServiceLoader;

/**
 * spi.interface21
 *
 * @author plusman
 * @since 11/28/20
 */
public class JavaSPITest {
    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(robot -> robot.sayHello());
    }
}
