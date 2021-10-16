package spi.interface21.impl;

import spi.interface21.Robot;

/**
 * spi.interface21.impl
 *
 * @author plusman
 * @since 11/28/20
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee");
    }
}
