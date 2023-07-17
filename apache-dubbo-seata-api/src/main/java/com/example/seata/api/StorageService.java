package com.example.seata.api;

import java.io.Serializable;

public interface StorageService extends Serializable {

    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);

}
