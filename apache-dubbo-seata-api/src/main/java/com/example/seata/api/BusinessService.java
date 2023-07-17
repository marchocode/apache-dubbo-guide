package com.example.seata.api;

import java.io.Serializable;

public interface BusinessService extends Serializable {

    void purchase(String userId, String commodityCode, int orderCount);

}
