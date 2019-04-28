package com.yatao.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//原理 map kv 键值对
class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rrwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        rrwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写入" + key);
            //暂停一会
            TimeUnit.SECONDS.sleep(2);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rrwLock.writeLock().unlock();
        }

    }

    public void get(String key) {
        rrwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取:");
            TimeUnit.SECONDS.sleep(2);
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成" + value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rrwLock.readLock().unlock();
        }


    }
}

/**
 * 多线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 * 但是如果有一个线程想去修改共享资源，就不应该再有其他线程 对该资源进读或者写
 * 总结
 * 读 读 可共存
 * 读 写 不可以共存
 * 写 写 不可以共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }

}
