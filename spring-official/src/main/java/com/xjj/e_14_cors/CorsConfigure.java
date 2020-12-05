package com.xjj.e_14_cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author LJ
 * @Date 2020/11/30
 * msg
 */

@Configuration
public class CorsConfigure {
    @Bean
    public WebMvcConfigurer cors() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting")
                        .allowedOrigins("http://localhost:8080");
            }
        };
    }
}
