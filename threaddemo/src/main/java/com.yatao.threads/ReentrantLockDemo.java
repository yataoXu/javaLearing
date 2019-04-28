package com.yatao.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getId()+": invoked send SMS()");
        sendEMail();

    }

    public synchronized void sendEMail(){
        System.out.println(Thread.currentThread().getId()+": invoked send EMail()");
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+": invoked send SMS()");
            set();
        }finally {
            lock.unlock();

        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+": invoked send EMail()");
        }finally {
            lock.unlock();
        }
    }


}

/**
 * 指的是同一个线程外层函数获得锁以后，内存递归函数仍然能获取该锁的代码，
 * 在同一个线程在外层方法获取锁的时候，再进入内层方法会自动获取锁。
 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 * （所有中文都能看懂，读了之后还是不知道）。
 *
 *
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSMS();
        },"t1").start();

        new Thread(()->{
            phone.sendSMS();
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==================");
        Thread thread = new Thread(phone);
        Thread thread1 = new Thread(phone);
        thread.start();
        thread1.start();
    }
}
