
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_clumps_init.personInfo;

import com.huawei.data_clumps_init.personInfo.constant.Constant;
import com.huawei.data_clumps_init.personInfo.model.Address;
import com.huawei.data_clumps_init.personInfo.model.Gender;

/**
 * 用户信息
 *
 * @since 2021-11-03
 */
public class PersonInfoManage {
    private final String firstName;

    private final String lastName;

    private final Gender gender;
    private final Address address = new Address();

    public PersonInfoManage(String firstName, String lastName, Gender gender, Address addr) {
        // …… do something. eg:check is legal
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address.setProvince(addr.getProvince());
        this.address.setCity(addr.getCity());
        this.address.setStreet(addr.getStreet());
    }

    /**
     * 按打印格式获取姓名
     * 
     * @return 打印格式的姓名
     */
    public String getName() {
        // …… do something. eg: auth
        return "First Name: " + firstName + Constant.LINE_SEPARATOR
            + "Last Name: " + lastName;
    }

    /**
     * 按打印格式获取性别
     *
     * @return 性别
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * 按打印格式获取地址信息
     * 
     * @return 地址信息
     */
    public String getAddress() {
        // …… do something. eg: auth
        return "Province: " + address.getProvince() + Constant.LINE_SEPARATOR
            + "City: " + address.getCity() + Constant.LINE_SEPARATOR
            + "Street: " + address.getStreet();
    }

    /**
     * 更新地址
     *
     * @param newAddress
     */
    public void updateAddress(Address newAddress) {
        // …… do something. eg: auth, check……
        this.address.setProvince(newAddress.getProvince());
        this.address.setCity(newAddress.getCity());
        this.address.setStreet(newAddress.getStreet());

        doNotify(newAddress.getProvince(), newAddress.getCity());
    }

    private void doNotify(String province, String city) {
        // …… do something. eg: notify others
        System.out.println("do something notify " + province + " " + city);
    }

    /**
     * 按打印格式获取搬移记录
     * 
     * @param newProvince 新省份
     * @param newCity 新城市
     * @param newStreet 新街道
     * @return 搬移记录
     */
    public String moveToAnotherPlace(String newProvince, String newCity, String newStreet) {
        // …… do something. eg: some business……
        return "move from: " + Constant.LINE_SEPARATOR
            + "\t" + this.address.getProvince() + " " + this.address.getCity() + " " + this.address.getStreet() + Constant.LINE_SEPARATOR
            + "to: " + Constant.LINE_SEPARATOR
            + "\t" + newProvince + " " + newCity + " " + newStreet;
    }
}