package com.yatao.jvm.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    /**
     * 当系统内存充足时它不会被回收
     */
    public static void softRef_Memory_Enough(){
        Object o1 =new Object();
        SoftReference<Object> softRef = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softRef.get());
    }

    /**
     * 当系统内存不充足时它会被回收
     *
     * JVM 配置，故意产生大对象并配置小内存，让它的内存不足 导致OOM
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough(){
        Object o1 =new Object();
        SoftReference<Object> softRef = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softRef.get());

        o1 =null;
        System.gc();

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softRef.get());
        }

    }

    public static void main(String[] args) {

//        softRef_Memory_Enough();

        softRef_Memory_NotEnough();


    }
}
