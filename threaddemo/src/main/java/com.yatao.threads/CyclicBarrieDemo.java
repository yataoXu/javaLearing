package com.yatao.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 集满7颗龙珠召唤神龙
 */
public class CyclicBarrieDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier =
                new CyclicBarrier(7, () -> {
                    System.out.println("***** 召唤神龙");
                });

        for (int i = 1; i <= 7 ; i++) {
            final int  tmpInt = i;
           new Thread(()->{
               System.out.println(Thread.currentThread().getId()+"收集到第"+tmpInt+"颗龙珠");
               try {
                   cyclicBarrier.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
           },String.valueOf(i)).start();
        }
    }
}
