package com.yatao.threads;

import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Runnable接口
 * 继承Thread类
 * 实现Callable接口 future  ，方法可以有返回值，并且可以抛出异常。
 * 线程池
 */

class MyThread0 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("***********come in");
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyThread1 t1 =  new MyThread1();
//        t1.start();
//        Thread  t0 =  new Thread(new MyThread0());
//        t0.start();
        int result = 100;
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "AA").start();
        new Thread(futureTask, "BB").start();
        Integer result02 = null;
        while (!futureTask.isDone()) {
             result02 = futureTask.get(); //要求获得callable 线程计算的结果
        }
        System.out.println("************result:" + (result + result02));

    }


}

