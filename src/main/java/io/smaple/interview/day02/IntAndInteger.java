package io.smaple.interview.day02;

import org.junit.Test;

/**
 * @author daffupman
 * @since 2019/12/5 10:02
 */
public class IntAndInteger {

    @Test
    public void test() {
        // 1. new两个Integer对象，使用new创建的对象位于堆
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(1);
        System.out.println(a1 == a2);

        // 2. Integer变量（常量池中）和使用new创建的对象（堆）
        Integer b1 = 2;
        Integer b2 = new Integer(2);
        System.out.println(b1 == b2);

        // 3. 两个Integer变量，考虑范围[-128,127]
        Integer c1 = 3;
        Integer c2 = 3;
        System.out.println(c1 == c2);
        Integer d1 = 128;
        Integer d2 = 128;
        System.out.println(d1 == d2);

        // 4. int和Integer的变量/new Integer(),通过拆箱机制，无需考虑范围
        int e1 = 4;
        Integer e2 = new Integer(4);
        System.out.println(e1 == e2);
        int f1 = 128;
        Integer f2 = new Integer(128);
        System.out.println(f1 == f2);
    }
}
