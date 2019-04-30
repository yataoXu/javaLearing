package com.yatao.jvm.reference;

import java.sql.SQLOutput;

/**
 * 强引用
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();// 这样定义默认就是强引用
        Object o2 = o1;  
        o1 = null;
        System.gc();
        System.out.println(o2);
    }
}
