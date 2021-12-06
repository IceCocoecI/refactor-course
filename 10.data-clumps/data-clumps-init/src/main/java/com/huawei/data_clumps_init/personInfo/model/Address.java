package com.huawei.data_clumps_init.personInfo.model;

import com.huawei.data_clumps_init.personInfo.constant.Constant;

public class Address {
    private String province;

    private String city;

    private String street;

    public Address() {
    }

    /**
     * @param province 省
     * @param city 市
     * @param street 街道
     */
    public Address(String province, String city, String street) {
        this.province = province;
        this.city = city;
        this.street = street;
    }

    public String printAddress() {
        return "Province: " + province + Constant.LINE_SEPARATOR
            + "City: " + city + Constant.LINE_SEPARATOR
            + "Street: " + street;
    }

    public String printMoveInfo(Address moveToAddress) {
        return "move from: " + Constant.LINE_SEPARATOR
            + "\t" + province + " " + city + " " + street + Constant.LINE_SEPARATOR
            + "to: " + Constant.LINE_SEPARATOR
            + "\t" + moveToAddress.province + " " + moveToAddress.city + " " + moveToAddress.street;
    }

    public void update(Address newAddress) {
        this.province = newAddress.province;
        this.city = newAddress.city;
        this.street = newAddress.street;
    }

    public void doNotify() {
        // …… do something. eg: notify others
        System.out.println("do something notify " + province + " " + city);
    }
}