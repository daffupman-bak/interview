package io.smaple.interview.day04.singleton;

/**
 * 饿汉式的单例模式
 *
 * @author daffupman
 * @since 2019/12/5 16:11
 */
public class Singleton {

    // 在程序内直接创建实例
    private static final Singleton instance = new Singleton();

    // 私有化构造器
    private Singleton() {}

    // 用于返回实例的方法
    public static Singleton getInstance() {
        return instance;
    }
}
