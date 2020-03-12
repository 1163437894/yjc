package com.yjc.test;

import com.yjc.constants.LockConstants;
import com.yjc.redis.RedisLock;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class LockCase1 extends RedisLock {

    public LockCase1(Jedis jedis, String lockKey) {
        super(jedis, lockKey);
    }

    @Override
    public void lock() {
        while (true) {
            SetParams params = new SetParams();
            String result = jedis.set(lockKey, "value", SetParams.setParams().nx());
            if (LockConstants.OK.equals(result)) {
                System.out.println(Thread.currentThread().getId() + "加锁成功!");
                break;
            }
        }
    }

    @Override
    public void unlock() {
        jedis.del(lockKey);
    }
}
