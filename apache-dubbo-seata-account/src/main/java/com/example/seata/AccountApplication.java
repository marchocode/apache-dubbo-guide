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
public class AccountApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    private final Logger logger = LoggerFactory.getLogger(AccountApplication.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        jdbcTemplate.execute("DELETE FROM account_tbl");
        logger.info("execute prepare sql...");

        jdbcTemplate.execute("INSERT INTO `account_tbl`(`user_id`, `money`) VALUES (1, 1000)");
    }
}
