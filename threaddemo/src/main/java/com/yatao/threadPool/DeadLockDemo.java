package com.yatao.threadPool;

import java.util.concurrent.TimeUnit;

/**
 * 死锁是指两个或者两个以上的进程在执行的过程中，
 * 因争夺资源而造成的一种相互等待的现象，
 * 若无外力干涉那他们都将无法推进下去
 */

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "1自己持有自己的:" + lockA + "尝试获取" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "2自己持有自己的:" + lockB + "尝试获取" + lockA);
            }
        }

    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA, lockB), "ThreadAA").start();
//        new Thread(new HoldLockThread(lockA, lockB), "ThreadBB").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBB").start();

        /**
         *    linux      ps           ls  -l
         *    window    jps           jps -l
         */

    }
}
