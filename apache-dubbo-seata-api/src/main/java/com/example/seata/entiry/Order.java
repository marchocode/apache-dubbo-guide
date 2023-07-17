package com.example.seata.entiry;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Order implements Serializable {

    /**
     * The Id.
     */
    public long id;
    /**
     * The User id.
     */
    public String userId;
    /**
     * The Commodity code.
     */
    public String commodityCode;
    /**
     * The Count.
     */
    public int count;
    /**
     * The Money.
     */
    public int money;

}
