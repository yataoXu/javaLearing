package com.yatao.threadPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CustomerThreadPool {
    public static void main(String[] args) {
        int count = 4;
        ExecutorService threadPool = new ThreadPoolExecutor(count,
                8, 30,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CountDownLatch countDownLatch = new CountDownLatch(count);

        Integer[] numberInt = {2, 5, 6, 3, 6, 42, 6, 88, 3, 1, 53, 75, 223, 6, 7, 345, 21, 67, 24, 78, 6, 42, 12};
        List<Integer> list = Arrays.asList(numberInt);
        int size = list.size();
        final Integer max_size = size / count;
        try {
            for (int i = 0; i < count; i++) {
                final int index = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());

                    if (index != count - 1) {
                        System.out.println((index * max_size+(index + 1) * max_size));
                    } else {
                        System.out.println(index * max_size+size);
                    }
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                });
            }
            countDownLatch.await();
            System.out.println("main线程执行");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
