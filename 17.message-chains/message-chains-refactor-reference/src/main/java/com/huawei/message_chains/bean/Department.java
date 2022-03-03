/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.message_chains.bean;

/**
 * 公司的一个部门信息，公司拥有不同的部门，部门地址{@link Address}可能不同。
 *
 * @since 2021-11-11
 */
public class Department {
    /** 地址信息 */
    private Address address;

    public Department(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

}