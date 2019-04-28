package com.yatao.threads;

//原理 map kv 键值对
class myCache{

}

/**
 *  多线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 *  但是如果有一个线程想去修改共享资源，就不应该再有其他线程 对该资源进读或者写
 *  总结
 *          读 读 可共存
 *          读 写 不可以共存
 *          写 写 不可以共存
 */
public class ReadWriteLockDemo {
}
