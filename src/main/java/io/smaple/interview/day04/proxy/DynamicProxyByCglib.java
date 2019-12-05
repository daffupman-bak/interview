package io.smaple.interview.day04.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <h3>使用cglib实现动态代理</h3>
 *
 * @author daffupman
 * @since 2019/12/5 16:47
 */
public class DynamicProxyByCglib<T> {

    private T target;

    public DynamicProxyByCglib(T target) {
        this.target = target;
    }

    public T getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * @param o             生成的代理对象：China$$EnhancerByCGLIB$$ba67c54
             * @param method        被代理对象的方法：China.sayHi()
             * @param objects       被代理对象的方法的参数：[Ljava.lang.Object;@490d6c15
             * @param methodProxy   被代理对象的方法的代理对象：MethodProxy@490d6c15
             * @return              返回代理对象
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("1");
                // 使用代理对象的方法的代理方法对象调用invokeSuper方法，入参代理对象和参数
                // 即代理对象调用被代理类的方法的代理类
                Object res = methodProxy.invokeSuper(o, objects);
                System.out.println("2");
                return res;
            }
        });
        return (T) enhancer.create();
    }
}
