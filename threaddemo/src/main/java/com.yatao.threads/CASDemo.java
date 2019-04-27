package com.yatao.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1 CAS 是什么  比较并交换
 *
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(5);

        // Atomically sets the value to the given updated value
        // 若变量的值是expect所给的值，则update成update value
        System.out.println(atomic.compareAndSet(5,2019) +"current date"+atomic.get());
        System.out.println(atomic.compareAndSet(5,1000) +"current date"+atomic.get());
        atomic.getAndIncrement();

    }

}
