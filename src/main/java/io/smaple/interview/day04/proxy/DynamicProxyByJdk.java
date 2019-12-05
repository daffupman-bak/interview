package io.smaple.interview.day04.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <h3>动态代理</h3>
 *
 * <p>
 *     使用jdk方式只能对实现类做代理
 * </p>
 *
 * @author daffupman
 * @since 2019/12/5 16:20
 */
public class DynamicProxyByJdk<T> {

    private T target;

    public DynamicProxyByJdk(T target) {
        this.target = target;
    }

    public T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                            target.getClass().getInterfaces(),
                                            (proxy, method, args) -> {
                                                System.out.println("前置方法");
                                                Object result = method.invoke(target, args);
                                                System.out.println("后置方法");
                                                return result;
                                            });
    }
}
