package com.yatao.threads;


import java.util.concurrent.atomic.AtomicInteger;

class Demo {
    volatile int number = 0;

    public void addTo60() {
        number = 60;
    }

    public void numberAdd() {
        number++;
    }

    AtomicInteger atomic = new AtomicInteger();

    public void numberAtomic(){
        atomic.getAndIncrement();
    }
}

/**
 * 验证volatile的可见性
 * 假如int number = 0; number 变量没有添加volatile关键字修饰，没有可见性
 * 添volatile修饰，可以解决可见性问题
 * 验证volatile 不保证原子性
 */

public class VolatileDemo {
    public static void main(String[] args) {
        for (int t = 0; t < 20; t++) {
            Demo demo = new Demo();
            for (int i = 0; i < 20; i++) {
                new Thread(() -> {
                    for (int j = 0; j < 1000; j++) {
                        demo.numberAdd();
                        demo.numberAtomic();
                    }
                }, String.valueOf(i)).start();
            }

            // 需要等待上面的线程完成后，再用main线程查看number的最后结果
            // 最少会有main gc 两个线程
            while (Thread.activeCount() > 2) {
                Thread.yield();
            }

            System.out.println(Thread.currentThread().getName() + "finally number value : " + demo.atomic);


        }
    }
}