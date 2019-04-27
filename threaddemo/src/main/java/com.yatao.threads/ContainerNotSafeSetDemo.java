package com.yatao.threads;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 * ArrayList 是线程不安全的
 * why add方法是没有加锁的
 */
public class ContainerNotSafeSetDemo {
    public static void main(String[] args) {
        Set set = new CopyOnWriteArraySet();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().subSequence(0, 6));
                System.out.println(Thread.currentThread().getName()+"-----"+set);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException
        /**
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         * 2 导致原因
         * 3 解决方案
         *      1 Collections.synchronizedSet(new HashSet<>());
         *      2 使用 java.util.concurrent.CopyOnWriteArraySet;
         * 4 优化建议
         */
    }
}
