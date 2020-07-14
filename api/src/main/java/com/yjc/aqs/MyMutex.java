package com.yjc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义互斥锁
 *
 * @author yjc
 */
public class MyMutex implements Lock {


    //自定义同步器
    private static class MySyc extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {

            //重写获取同步状态方法


            //aqs提供的方法 通过cas保证原子同步性
            if(compareAndSetState(0,arg)){




            }




            return false;
        }
    }


    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
