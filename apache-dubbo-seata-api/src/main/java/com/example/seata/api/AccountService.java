package com.example.seata.api;

import java.io.Serializable;

public interface AccountService extends Serializable {

    /**
     * 从用户账户中借出
     */
    void debit(String userId, int money);

}
