package io.smaple.interview.day04.proxy;

/**
 * 目标类：即被代理的类
 *
 * @author daffupman
 * @since 2019/12/5 16:32
 */
public class China implements Person{

    @Override
    public void sayHi() {
        System.out.println("原来的业务逻辑");
    }
}
