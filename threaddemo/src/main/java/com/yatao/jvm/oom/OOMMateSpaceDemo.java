package com.yatao.jvm.oom;


import jdk.jfr.events.ExceptionThrownEvent;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:+MetaspaceSize=8m -XX:+MaxMetaspaceSize=8m
 *
 * Error occurred during initialization of VM
 * MaxMetaspaceSize is too small.
 *
 *
 * <p>
 * java8 及以后的版本使Metaspace替代永久代
 * <p>
 * MetaSpace是方法区在HotSpot中来实现，它与持久代最大的区别在于：Metaspace并不在虚拟机内存中而是使用本地内存，
 * 也即在java8中，clase meta（the virtual machine interal presentation of java class）,被存储在叫做Metaspace的native memory
 * <p>
 * 永久代（java8后被metaspace取代）存放一下数据
 * 虚拟机加载的类信息
 * 常量池
 * 静态变量、方法
 * 即时编译后的代码
 * <p>
 * 模拟Metaspace空间溢出，我们不断生成类往元空间存放。
 */
public class OOMMateSpaceDemo {
    static class OOMTest{}
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }

        } catch (Exception e) {
            System.out.println("=================i:" + i);
            e.printStackTrace();
        }

    }
}
