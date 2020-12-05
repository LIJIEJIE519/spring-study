package com.xjj.e_15_cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * @Author LJ
 * @Date 2020/12/1
 * msg
 */

@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("book")
    public Book getByIsbn(String isbn) {
        simulateSlow();
        return new Book(isbn, "book");
    }

    // 模拟数据库查询行为
    private void simulateSlow() {
        try {
            Thread.sleep(3000L);
        } catch (Exception e) {
            return;
        }
    }


}
