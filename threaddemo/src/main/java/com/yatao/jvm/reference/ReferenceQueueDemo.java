package com.yatao.jvm.reference;

import sun.plugin2.os.windows.OVERLAPPED;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 引用队列（ReferenceQueue)
 * 效果：引用队列可以配合软引用、弱引用及幽灵引用使用，当引用的对象将要被JVM回收时，会将其加入到引用队列中。
 *
 *  创建引用的时候可以指定关联的队列，当GC释放对象内存的时候，会将引用加入到引用对列
 *  如果程发现某个虚引用已经被加入到引用对列，那么就可以在所引用的对象的内被回收前采取必要的行文
 *  这相当于是一种通知机制
 *
 *  当关联的引用对列中有数据的时候，意味着引用指向的堆内存中的对象被回收，通过这种方式，JVM允许我么在对象被销毁后
 *  做一些我们想做的事
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        // 在被回收时，可以保存到引用队列中
        WeakReference<Object> weakRef = new WeakReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(weakRef.get());
        System.out.println(referenceQueue.poll());
        System.out.println("gc前");
        System.out.println("==================");

        o1 = null;
        System.gc();

        TimeUnit.SECONDS.sleep(1);

        System.out.println(o1);
        System.out.println(weakRef.get());
        System.out.println(referenceQueue.poll());

    }
}
