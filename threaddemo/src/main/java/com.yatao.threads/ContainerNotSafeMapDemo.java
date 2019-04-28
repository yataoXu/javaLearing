package com.yatao.threads;


import java.util.*;

/**
 * 集合类不安全的问题
 * ArrayList 是线程不安全的
 * why add方法是没有加锁的
 */
public class ContainerNotSafeMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());//new ConcurrentHashMap<>();//new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().subSequence(0, 6).toString());
                System.out.println(Thread.currentThread().getName() + "-----" + map);
            }, String.valueOf(i)).start();
        }


        //java.util.ConcurrentModificationException
        /**
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         * 2 导致原因
         * 3 解决方案
         *      1 new ConcurrentHashMap<>();
         *      2  Collections.synchronizedMap(new HashMap<>())
         * 4 优化建议
         */
    }
}
