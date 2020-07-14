package com.yjc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(() -> test(), "线程1").start();
        new Thread(() -> test(), "线程2").start();
    }

    private static void test() {
        System.out.println(Thread.currentThread().getName() + "進入方法");
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
