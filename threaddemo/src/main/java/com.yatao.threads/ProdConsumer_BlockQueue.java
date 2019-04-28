package com.yatao.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FLAG = true; //默认开启 进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> queue = null;

    public MyResource(BlockingQueue<String> queue) {
        this.queue = queue;
        // 抽象往高处写
        // 落地需要足够的细节
        System.out.println(queue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = queue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列成功 :" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t FLAG 为false 生产结束");
    }

    public void myConsumer() throws Exception {
        while (FLAG) {
            String poll = queue.poll(2L, TimeUnit.SECONDS);
            if (null == poll || poll.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费退出" + poll);
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列poll " + poll);
        }
        System.out.println(Thread.currentThread().getName() + "\t 消费者退出");
    }

    public void stop() throws Exception {
        this.FLAG = false;
    }
}

/**
 * volatile/CAS/atomicInteger/BlockQueue/ 线程交互 /原子引用
 */
public class ProdConsumer_BlockQueue {
    public static void main(String[] args) throws Exception {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "PROD").start();

        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "生产线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main线程调用stop");
        myResource.stop();
    }
}
