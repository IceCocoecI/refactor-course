/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.message_chains.bean;

/**
 * 街道信息，街道名称，街道号码
 *
 * @since 2021-11-11
 */
public class Street {
    /** 街道名称 */
    private String streetName;

    /** 街道编号 */
    private Integer streetNo;

    public Street(String streetName, Integer streetNo) {
        this.streetName = streetName;
        this.streetNo = streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getStreetNo() {
        return streetNo;
    }
}