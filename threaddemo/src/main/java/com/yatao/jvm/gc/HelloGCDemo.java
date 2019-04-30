package com.yatao.jvm.gc;

public class HelloGCDemo {
    public static void main(String[] args) {
        // 返回java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 返回java虚拟机中的最大内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY(-Xms)"+totalMemory+"字节，"+(totalMemory/1024/1024)+"MB");
        System.out.println("MAX_MEMORY(-Xmx)"+maxMemory+"字节，"+(maxMemory/1024/1024)+"MB");
    }
}
