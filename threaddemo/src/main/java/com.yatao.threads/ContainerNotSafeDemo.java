package com.yatao.threads;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全的问题
 * ArrayList 是线程不安全的
 * why add方法是没有加锁的
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List list = new CopyOnWriteArrayList();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().subSequence(0, 6));
                System.out.println(Thread.currentThread().getName()+"-----"+list);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException
        /**
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         * 2 导致原因
         * 3 解决方案
         *      1 使用Vector
         *              add()加锁啦，数据一致性可以得到保证，但是并发性大大降低
         *      2 Collections.synchronizedList(new ArrayList<>());
         *      3 使用 java.util.concurrent.CopyOnWriteArrayList
         * 4 优化建议
         */
    }
}
