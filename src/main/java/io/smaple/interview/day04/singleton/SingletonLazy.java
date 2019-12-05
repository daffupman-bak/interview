package io.smaple.interview.day04.singleton;

/**
 * 懒汉式的单例模式
 *
 * @author daffupman
 * @since 2019/12/5 16:11
 */
public class SingletonLazy {

    // 默认没有实例
    private static SingletonLazy instance = null;

    // 私有化构造器
    private SingletonLazy() {}

    // 用于返回实例的方法
    public static SingletonLazy getInstance() {
        // double check: 实现线程安全
        if(instance == null) {
            synchronized (SingletonLazy.class) {
                if(instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
