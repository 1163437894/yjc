package com.yjc.exception;

public class RedisLockException extends RuntimeException {

    public RedisLockException() {

    }


    public RedisLockException(String message) {
        super(message);
    }

    public RedisLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
