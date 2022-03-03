/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.message_chains.bean;

/**
 * 地址信息, 包含街道{@link Street}等信息
 *
 * @since 2021-11-11
 */
public class Address {
    /** 街道信息 */
    private Street street;

    public Address(Street street) {
        this.street = street;
    }

    public Street getStreet() {
        return street;
    }
}