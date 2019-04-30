package com.yatao.jvm.oom;

/**
 * OOM之Java heap space :堆内存不够用
 * -Xmx5m -Xms5m
 */
public class OOMJavaHeapSpaceDemo {
    public static void main(String[] args) {
        Byte[] bytes = new Byte[30*1024*1024];
    }
}
