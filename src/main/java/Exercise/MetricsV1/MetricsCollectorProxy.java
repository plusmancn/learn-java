package Exercise.MetricsV1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IUserController {
    void login();
    void getUserName();
}

class UserController implements  IUserController {
    @Override
    public void login() {
        System.out.println("user is login");
    }

    @Override
    public void getUserName() {
        System.out.println("You name is plusman");
    }
}

/**
 * 动态代理实践
 */
public class MetricsCollectorProxy {

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);

        return Proxy.newProxyInstance(
                proxiedObject.getClass().getClassLoader(),
                interfaces,
                handler
        );
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            System.out.println(apiName + ": response in " + responseTime + "ms");
            return result;
        }
    }

    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        // TODO: 类强制转换本身会抛错，只有使用接口进行强制转换，那如果该类没有定义接口，该如何实现动态代理呢？Spring AOP 一定有解决方案，可以阅读源码
        // UserController userController = (UserController) proxy.createProxy(new UserController());
        IUserController userController = (IUserController) proxy.createProxy(new UserController());

        userController.getUserName();
        userController.login();
    }
}
