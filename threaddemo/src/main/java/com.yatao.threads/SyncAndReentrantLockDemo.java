package com.yatao.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：多线程之间按照顺序调用，实现A->B->C 三个线程启动，要求如下：
 * AA 打印5次 BB打印10次 CC 打印15次
 * 紧接着
 * AA 打印5次 BB打印10次 CC 打印15次
 * 。。。。
 * 共10次
 */

class ShareResoure {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print() {
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                c1.await();
            }
            // 2 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void print2() {
        lock.lock();
        try {
            // 判断
            while (number != 2) {
                c2.await();
            }
            // 2 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void print3() {
        lock.lock();
        try {
            // 判断
            while (number != 3) {
                c3.await();
            }
            // 2 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResoure shareResoure = new ShareResoure();
        for (int i = 0; i < 10; i++) {


            new Thread(() -> {
                shareResoure.print();
            }, "A").start();

            new Thread(() -> {
                shareResoure.print2();
            }, "B").start();

            new Thread(() -> {
                shareResoure.print3();
            }, "C").start();

        }
    }
}
