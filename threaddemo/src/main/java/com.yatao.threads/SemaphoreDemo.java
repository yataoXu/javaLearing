package com.yatao.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 模拟6个车抢占3个车位
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() +"抢到车位");
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() +"抢到车位10S后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();

        }
    }

}
