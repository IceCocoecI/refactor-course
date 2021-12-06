
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_clumps_init.personInfo;

import com.huawei.data_clumps_init.personInfo.constant.Constant;
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

    private String province;

    private String city;

    private String street;

    public PersonInfoManage(String firstName, String lastName, Gender gender, String province, String city,
        String street) {
        // …… do something. eg:check is legal
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.province = province;
        this.city = city;
        this.street = street;
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
        return "Province: " + province + Constant.LINE_SEPARATOR
            + "City: " + city + Constant.LINE_SEPARATOR
            + "Street: " + street;
    }

    /**
     * 更新地址
     * 
     * @param province 省
     * @param city 市
     * @param street 街道
     */
    public void updateAddress(String province, String city, String street) {
        // …… do something. eg: auth, check……
        this.province = province;
        this.city = city;
        this.street = street;

        doNotify(province, city);
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
            + "\t" + this.province + " " + this.city + " " + this.street + Constant.LINE_SEPARATOR
            + "to: " + Constant.LINE_SEPARATOR
            + "\t" + newProvince + " " + newCity + " " + newStreet;
    }
}