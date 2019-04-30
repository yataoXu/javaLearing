package com.yatao.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * 虚引用必须和引用队列（ReferenceQueue)联合使用
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        // 在被回收时，可以保存到引用队列中
        // 有点像 spring 的后置通知
        PhantomReference<Object> phantomRef = new PhantomReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(phantomRef.get());
        System.out.println(referenceQueue.poll());
        System.out.println("以上为 gc前");
        System.out.println("==================");

        o1 = null;
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o1);
        System.out.println(phantomRef.get());
        System.out.println(referenceQueue.poll().getClass().getName()+"被回收啦");
    }
}
