package com.xjj.e_08_redis_message;

import com.xjj.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * @Author LJ
 * @Date 2020/11/26
 * msg
 */

//@Component
public class MessagingRedis{

    private static final Logger log = LoggerFactory.getLogger(MessagingRedis.class);

    @Bean
    Receiver receiver() {
        return new Receiver();
    };

    // 容器 让监听器和消息容器连接到Redis服务器。
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory factory,
                                            MessageListenerAdapter adapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        // 监听 chat 管道的消息。
        container.addMessageListener(adapter, new PatternTopic("chat"));

        return container;
    }

    @Bean
    MessageListenerAdapter adapter(Receiver receiver) {
        // 注册监听器及监听方法
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

//    @Bean
    StringRedisTemplate template(RedisConnectionFactory factory) {
        // 发送信息
        return new StringRedisTemplate(factory);
    }

//    @Bean
    CommandLineRunner initRedis() {
        return args -> {
            StringRedisTemplate template = BeanUtils.getBean(StringRedisTemplate.class);
            Receiver receiver = BeanUtils.getBean(Receiver.class);

            while (receiver.getCounter() <= 3) {
                log.info("=====发送消息======");
                // 发送到 chat 管道
                template.convertAndSend("chat", "Hello from Redis!" +
                        receiver.getCounter());
                Thread.sleep(500L);
            }
//            System.exit(0);
        };
    }
}
