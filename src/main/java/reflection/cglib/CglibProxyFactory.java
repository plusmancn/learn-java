package reflection.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author plusman
 * @since 2021/10/16 10:01 PM
 */
public class CglibProxyFactory {
    public static void main(String[] args) {
        HelloWorld helloWorld = (HelloWorld) getProxy(HelloWorld.class, new HelloWorld());
        helloWorld.sayHello();
    }
    
    public static Object getProxy(Class<?> clazz, Object instance) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor(instance));
        // 创建代理类
        return enhancer.create();
    }
}
