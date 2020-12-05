package com.xjj.e_07_upload;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author LJ
 * @Date 2020/11/26
 * msg 上传文件
 */
@Component
@EnableConfigurationProperties(StorageProperties.class) // 上传文件
public class UploadApplication {
        /* 文件上传服务 */
    @Bean
    CommandLineRunner initUpload(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}

