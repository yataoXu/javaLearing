package com.yatao.jvm.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 =new Object();
        WeakReference<Object> weakRef = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakRef.get());

        o1= null;
        System.gc();
        System.out.println("===============");
        System.out.println(o1);
        System.out.println(weakRef.get());
    }
}
