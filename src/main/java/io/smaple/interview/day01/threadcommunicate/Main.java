package io.smaple.interview.day01.threadcommunicate;

import org.junit.Test;

/**
 * <h3>线程通信测试</h3>
 * <p>
 *     有两个线程（线程A和线程B），A负责空调温度在0度的时候提高一度，B负责在空调温度1度的时候降低1度。如此反复10轮。
 * </p>
 *
 * @author daffupman
 * @since 2019/12/5 9:16
 */
public class Main {

    /**
     * 注意：只能使用main线程开启新线程，不能使用@test测试，否则线程执行的结果不可预测
     */
    public static void main(String[] args) {

        // 共享资料对象
        AirCondition ac = new AirCondition();

        // 温度提升线程：A
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ac.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        // 温度降低线程：B
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ac.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

    }

//    @Test
//    public void test() {
//        // 共享资料对象
//        AirCondition ac = new AirCondition();
//
//        // 温度提升线程：A
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    ac.incr();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "A").start();
//
//        // 温度降低线程：B
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    ac.decr();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "B").start();
//    }
}
