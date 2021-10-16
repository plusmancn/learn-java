package reflection.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author plusman
 * @since 2021/10/16 9:52 PM
 */
public class DebugMethodInterceptor implements MethodInterceptor {
    private Object target;
    
    public DebugMethodInterceptor(Object object) {
        super();
        this.target = object;
    }
    
    @Override 
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before Invoke");
        // this 也被增强了
        // proxy.invokeSuper(obj, args);
        
        // 类似 Spring AOP，其中 this 是原始对象
        proxy.invoke(target, args);
        
        System.out.println("After Invoke");
        return null;
    }
}
