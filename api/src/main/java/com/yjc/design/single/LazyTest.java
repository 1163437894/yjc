package com.yjc.design.single;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单例(懒汉式)
 *
 * @author yjc
 */
public class LazyTest {

    private static LazyTest lazyTest;

    private final static Lock lock = new ReentrantLock();

    private LazyTest() {

    }


    public static LazyTest getLazy() {
        if (lazyTest == null) {
            lazyTest = new LazyTest();
        }
        return lazyTest;
    }

    /**
     * 线程安全单例模式
     *
     * @return
     */
    public static LazyTest getLazySync() {
        lock.lock();
        try {
            if (lazyTest == null) {
                lazyTest = new LazyTest();
            }
        } finally {
            lock.unlock();
        }
        return lazyTest;
    }


}
