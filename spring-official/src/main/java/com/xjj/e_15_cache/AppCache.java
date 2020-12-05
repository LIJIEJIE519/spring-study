package com.xjj.e_15_cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author LJ
 * @Date 2020/12/1
 * msg
 */

@Component
public class AppCache implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);

    private final BookRepository book;

    public AppCache(BookRepository book) {
        this.book = book;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("查询书籍：");
        logger.info("isbn-1234 -->" + book.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + book.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + book.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + book.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + book.getByIsbn("isbn-1234"));
        logger.info("isbn-1234 -->" + book.getByIsbn("isbn-1234"));
    }
}
