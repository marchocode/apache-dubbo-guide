package com.example.seata.dubbo;

import com.example.seata.api.StorageService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

@DubboService
public class StockServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);

    private final JdbcTemplate jdbcTemplate;

    public StockServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void deduct(String commodityCode, int count) {
        LOGGER.info("Stock Service Begin ... xid: " + RootContext.getXID());
        LOGGER.info("Deducting inventory SQL: update storage_tbl set count = count - {} where commodity_code = {}", count,
                commodityCode);

        jdbcTemplate.update("update storage_tbl set count = count - ? where commodity_code = ?",
                new Object[]{count, commodityCode});
        LOGGER.info("Stock Service End ... ");
    }
}
