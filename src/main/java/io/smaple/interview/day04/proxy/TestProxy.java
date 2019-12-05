package io.smaple.interview.day04.proxy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 代理类测试
 *
 * @author daffupman
 * @since 2019/12/5 16:35
 */
public class TestProxy {

    @Test
    public void test() {
        Person p = new China();
        new StaticProxy(p).sayHi();
//        new DynamicProxyByJdk<>(p).getProxy().sayHi();
//        new DynamicProxyByCglib<>(p).getProxy().sayHi();
    }
}
