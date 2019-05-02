package com.yatao.singletion;

public class SingletonDemo5 {

    private static volatile SingletonDemo5 instance = null;

    private SingletonDemo5() {
        System.out.println(Thread.currentThread().getName() + "我是构造方法");
    }

    // DCL(double check lock Lock 双端检锁机制)
    // 有可能会出现指令重排
    public static SingletonDemo5 getSinglet() {
        if (instance == null) {
            synchronized (SingletonDemo5.class) {
                if (instance == null) {
                    instance = new SingletonDemo5();
                }
            }
        }
        return instance;
    }

}
