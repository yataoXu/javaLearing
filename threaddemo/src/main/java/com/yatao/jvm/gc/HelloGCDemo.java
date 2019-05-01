package com.yatao.jvm.gc;

import java.util.concurrent.TimeUnit;

public class HelloGCDemo {
    public static void main(String[] args) {
        // 返回java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 返回java虚拟机中的最大内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();
        try {
//            Byte[] bytes =new Byte[50*1024*1024]; XX:MaxTenuringThreshold
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TOTAL_MEMORY(-Xms)"+totalMemory+"字节，"+(totalMemory/1024/1024)+"MB");
        System.out.println("MAX_MEMORY(-Xmx)"+maxMemory+"字节，"+(maxMemory/1024/1024)+"MB");
    }
}
