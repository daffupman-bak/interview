package io.smaple.interview.day04.proxy;

/**
 * 静态代理
 *
 * @author daffupman
 * @since 2019/12/5 17:02
 */
public class StaticProxy implements Person {

    private Person p;

    public StaticProxy(Person p) {
        this.p = p;
    }

    @Override
    public void sayHi() {
        System.out.println("前置方法");
        p.sayHi();
        System.out.println("后置方法");
    }
}
