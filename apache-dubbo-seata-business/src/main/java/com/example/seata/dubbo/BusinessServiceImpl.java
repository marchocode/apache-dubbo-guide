package com.example.seata.dubbo;

import com.example.seata.api.BusinessService;
import com.example.seata.api.OrderService;
import com.example.seata.api.StorageService;
import com.example.seata.entiry.Order;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService
public class BusinessServiceImpl implements BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

    @DubboReference
    private final StorageService stockService;

    @DubboReference
    private final OrderService orderService;

    public BusinessServiceImpl(StorageService stockService, OrderService orderService) {
        this.stockService = stockService;
        this.orderService = orderService;
    }

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-demo-tx", rollbackFor = Exception.class)
    public void purchase(String userId, String commodityCode, int orderCount) {

        LOGGER.info("purchase begin ... xid: " + RootContext.getXID());
        stockService.deduct(commodityCode, orderCount);

        //stockService.batchDeduct(commodityCode, orderCount);
        Order order = orderService.create(userId, commodityCode, orderCount);
        LOGGER.info("purchase order={}", order);

    }


}
