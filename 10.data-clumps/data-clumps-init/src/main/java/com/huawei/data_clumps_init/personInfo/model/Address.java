package com.huawei.data_clumps_init.personInfo.model;

import com.huawei.data_clumps_init.personInfo.PersonInfoManage;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String printAddress(PersonInfoManage personInfoManage) {
        return "Province: " + getProvince() + Constant.LINE_SEPARATOR
            + "City: " + getCity() + Constant.LINE_SEPARATOR
            + "Street: " + getStreet();
    }
}