package com.yatao.threads;


import java.util.concurrent.TimeUnit;

/**
 * synchronized可以保证方法或者代码块在运行时，
 * 同一时刻只有一个方法可以进入到临界区，
 * 同时它还可以保证共享变量的内存可见性
 *
 *
 * Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：
 *
 * 普通同步方法，锁是当前实例对象
 * 静态同步方法，锁是当前类的class对象
 * 同步方法块，锁是括号里面的对象
 *
 */
public class SynchroziedTest  implements Runnable {
    private static int count;

    public SynchroziedTest() {
        count = 0;
    }

    public  void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        SynchroziedTest syncThread = new SynchroziedTest();
        Thread thread1 = new Thread(new SynchroziedTest(), "SyncThread1");
        Thread thread2 = new Thread(new SynchroziedTest(), "SyncThread2");
        thread1.start();
        thread2.start();

    }
}