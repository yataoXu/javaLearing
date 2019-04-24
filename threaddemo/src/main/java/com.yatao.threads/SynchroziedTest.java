package com.yatao.threads;


/**
 * synchronized可以保证方法或者代码块在运行时，
 * 同一时刻只有一个方法可以进入到临界区，
 * 同时它还可以保证共享变量的内存可见性
 *
 *
 * Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：
 *
 * 普通同步方法，锁是当前实例对象
 * 静态同步方法，锁是当前类的class对象
 * 同步方法块，锁是括号里面的对象
 *
 */
public class SynchroziedTest {



    public static void main(String[] args) {
        System.out.println("34223");
    }
}