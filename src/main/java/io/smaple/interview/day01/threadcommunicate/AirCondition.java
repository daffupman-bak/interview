package io.smaple.interview.day01.threadcommunicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源类：空调
 *
 * @author daffupman
 * @since 2019/12/5 9:20
 */
public class AirCondition {

    /**
     * 空调温度， 初始0度
     */
    private int temperature = 0;

    /**
     * 可重入锁及其相关条件
     */
    private Lock lock = new ReentrantLock();
    private Condition incrCondition = lock.newCondition();
    private Condition decrCondition = lock.newCondition();

    /**
     * 温度提升1度
     */
    public void incr() throws InterruptedException {
        // 加锁
        lock.lock();
        try {
            while(temperature != 0) {
                // 如果当前温度不是0度，则等待
                incrCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + " => 温度已提升，现在的温度为：" + (++ temperature));
            decrCondition.signalAll();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public void decr() throws InterruptedException {
        // 加锁
        lock.lock();
        try {
            while (temperature != 1) {
                // 如果当前问题不是1度，则等待
                decrCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + " => 温度已降低，现在的温度为：" + (-- temperature));
            incrCondition.signalAll();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

}
