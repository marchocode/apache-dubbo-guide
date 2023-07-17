package com.example.seata.dubbo;

import com.example.seata.api.AccountService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;

@DubboService
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private final JdbcTemplate jdbcTemplate;


    public AccountServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void debit(String userId, int money) {

        LOGGER.info("Account Service ... xid: " + RootContext.getXID());
        LOGGER.info("Deducting balance SQL: update account_tbl set money = money - {} where user_id = {}", money,
                userId);

        Integer balance = jdbcTemplate.queryForObject("select money from account_tbl where user_id= ?", new Object[]{userId}, new int[]{Types.INTEGER}, Integer.class);
        LOGGER.info("Account Service ... Balance: " + balance);

        if (balance.intValue() - money < 0) {
            throw new RuntimeException("No required balance..");
        }

        jdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?", new Object[]{money, userId});
        LOGGER.info("Account Service End ... ");

    }
}
