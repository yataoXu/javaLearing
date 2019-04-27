package com.yatao.threads;

public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "我是构造方法");
    }

    // DCL(double check lock Lock 双端检锁机制)
    // 有可能会出现指令重排
    public static SingletonDemo getSinglet() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

//        System.out.println(SingletonDemo.getSinglet() == SingletonDemo.getSinglet());
//        System.out.println(SingletonDemo.getSinglet() == SingletonDemo.getSinglet());
//        System.out.println(SingletonDemo.getSinglet() == SingletonDemo.getSinglet());
//        System.out.println("=========main 单机版 =========");
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getSinglet();
            }, String.valueOf(i)).start();
        }
    }
}
