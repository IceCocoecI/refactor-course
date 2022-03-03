/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_clumps_ref.personinfo.model;

import com.huawei.data_clumps_ref.personinfo.constant.Constant;

/**
 * 地址
 *
 * @since 2021-11-05
 */
public class Address {
    private String province;

    private String city;

    private String street;

    public Address() {
    }

    public Address(String province, String city, String street) {
        this.province = province;
        this.city = city;
        this.street = street;
    }

    /**
     * 打印格式的地址信息
     * 
     * @return 地址信息
     */
    public String printAddress() {
        return "Province: " + province + Constant.LINE_SEPARATOR
            + "City: " + city + Constant.LINE_SEPARATOR
            + "Street: " + street;
    }

    /**
     * 通知
     */
    public void doNotify() {
        // …… do something. eg: notify others
        System.out.println("do something notify " + province + " " + city);
    }

    /**
     * 打印格式的移动记录
     * 
     * @param anotherAddress 目的地址
     * @return 移动记录
     */
    public String printMoveInfo(Address anotherAddress) {
        return "move from: " + Constant.LINE_SEPARATOR
            + "\t" + province + " " + city + " " + street
            + Constant.LINE_SEPARATOR
            + "to: " + Constant.LINE_SEPARATOR
            + "\t" + anotherAddress.province + " " + anotherAddress.city + " " + anotherAddress.street;
    }

    /**
     * 地址更新
     * 
     * @param newAddress 新的地址
     */
    public void update(Address newAddress) {
        this.province = newAddress.province;
        this.city = newAddress.city;
        this.street = newAddress.street;
    }
}
