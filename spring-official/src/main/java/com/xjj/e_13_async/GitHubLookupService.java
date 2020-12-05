package com.xjj.e_13_async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * @Author LJ
 * @Date 2020/11/29
 * msg
 */

@Service
public class GitHubLookupService {

    private static final Logger log = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate template;

    public  GitHubLookupService(RestTemplateBuilder template) {
        this.template = template.build();
    }

    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        log.info("查找：" + user);
        String url = String.format("https://api.github.com/users/%s", user);
        // 请求远程rest服务
        User results = template.getForObject(url, User.class);
        Thread.sleep(1000L);
        // 请求完成
        return CompletableFuture.completedFuture(results);
    }
}
