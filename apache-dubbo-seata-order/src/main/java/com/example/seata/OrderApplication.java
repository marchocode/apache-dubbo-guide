package com.example.seata;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableDubbo
public class OrderApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    private final static Logger logger = LoggerFactory.getLogger(OrderApplication.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        logger.info("clean old data...");
        jdbcTemplate.execute("DELETE FROM order_tbl");
    }
}