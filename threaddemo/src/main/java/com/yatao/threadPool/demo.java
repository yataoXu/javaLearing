package com.yatao.threadPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;

public class demo {
    public static void main(String[] args) {
//        ExecutorService pool  = Executors.newCachedThreadPool();
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        int count = 4;
        ExecutorService pool = Executors.newFixedThreadPool(count);
        CountDownLatch countDownLatch =new CountDownLatch(count);
        Integer[] numberInt ={2,5,6,3,6,42,6,88,3,1,53,75,223,6,7,345,21,67,24,78,6,42,12};
        List<Integer> list  = Arrays.asList(numberInt);
        int size = list.size();
        final Integer max_size = size/ count;
            try {
                for (int i = 0; i < count; i++) {
                    final int index = i;
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() );
                    List<Integer> subList;
                    if(index != count-1){
                        subList = list.subList(index * max_size, (index + 1) * max_size);
                    } else {
                        subList = list.subList(index * max_size, size);
                    }
                    System.out.println(subList.toString());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        countDownLatch.countDown();
                    }
                });
                }
                countDownLatch.await();
                System.out.println("main线程执行");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                pool.shutdown();
            }
    }
}
