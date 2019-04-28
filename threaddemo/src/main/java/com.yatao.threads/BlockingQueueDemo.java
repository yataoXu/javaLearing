package com.yatao.threads;

import java.util.concurrent.*;

/**
 *     ArrayBlockingQueue; 是一个基于数据结构的有界阻塞队列，此队列按FIFO原则对元素进行排序
 *     LinkedBlockingQueue; 一个基于链表结构的阻塞队列，此队列按照FIFO 排序元素，吞吐量高于ArrayBlockingQueue
 *     SynchronousQueue; 一个不存储元素的阻塞队列，每个插入的操作必须等到另一个线程调用移除操作，
 *                         否则插入操作一直处于阻塞状态，吞吐量高于LinkedBlockingQueue。
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue  =new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
    }
}
