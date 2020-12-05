package com.xjj.e_04_database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author LJ
 * @Date 2020/11/25
 * msg 使用Jdbc连接数据库，H2 database[基于内存的数据库]
 */

//@Component("h2Database")
public class RelationalDataAccess implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(RelationalDataAccess.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override   // Spring boot 初始化之后调用
    public void run(String... args) throws Exception {
        log.info("创建表");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean").stream()
                .map(name -> name.split(" ")).collect(Collectors.toList());

        // 批量插入
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

        // RowMapper (ResultSet, int) -> T
        jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "John" },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));
    }
}
