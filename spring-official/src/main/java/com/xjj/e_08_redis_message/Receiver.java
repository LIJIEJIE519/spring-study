package com.xjj.e_08_redis_message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LJ
 * @Date 2020/11/26
 * msg 消息接收器, 作为消息监听器
 */

public class Receiver {
    //日志器
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);
    // 计数器
    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        log.info("收到消息：" + message);
        counter.incrementAndGet();
    }
    public int getCounter() {
        return counter.get();
    }
}
