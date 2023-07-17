package com.example.seata.api;

import com.example.seata.entiry.Order;

import java.io.Serializable;

public interface OrderService extends Serializable {

    /**
     * 创建订单
     */
    Order create(String userId, String commodityCode, int orderCount);

}
