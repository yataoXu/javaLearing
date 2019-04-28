package com.yatao.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue 没有容量
 * 与其他BlockingQueue不同，SynchronousQueue是一个不存储元素的BlockQueue
 * 每一个put操作必须等待一个take操作，否则不能继续添加元素，反之亦然
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" put 1" +System.currentTimeMillis());
                blockingQueue.put(1+"");
                System.out.println(Thread.currentThread().getName()+" put 2");
                blockingQueue.put(2+"");
                System.out.println(Thread.currentThread().getName()+" put 3");
                blockingQueue.put(3+"");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println(blockingQueue.take());
                TimeUnit.SECONDS.sleep(4);
                System.out.println(blockingQueue.take());
                TimeUnit.SECONDS.sleep(4);
                System.out.println(blockingQueue.take());

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();

    }
}
