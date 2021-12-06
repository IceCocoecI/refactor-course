
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_clumps_init.personInfo;

import com.huawei.data_clumps_init.personInfo.constant.Constant;
import com.huawei.data_clumps_init.personInfo.model.Address;
import com.huawei.data_clumps_init.personInfo.model.Gender;
import com.huawei.data_clumps_init.personInfo.model.Name;

/**
 * 用户信息
 *
 * @since 2021-11-03
 */
public class PersonInfoManage {

    private final Gender gender;
    private final Address address = new Address();
    private final Name name;

    public PersonInfoManage(Name name, Gender gender, Address addr) {
        // …… do something. eg:check is legal
        this.name = name;
        this.gender = gender;
        address.update(addr);
    }

    /**
     * 按打印格式获取姓名
     * 
     * @return 打印格式的姓名
     */
    public String getName() {
        // …… do something. eg: auth
        return "First Name: " + this.name.getFirstName() + Constant.LINE_SEPARATOR
            + "Last Name: " + this.name.getLastName();
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
        return address.printAddress();
    }

    /**
     * 更新地址
     *
     * @param newAddress
     */
    public void updateAddress(Address newAddress) {
        // …… do something. eg: auth, check……
        address.update(newAddress);

        newAddress.doNotify();
    }

    /**
     * 按打印格式获取搬移记录
     * 
     *
     * @param moveToAddress@return 搬移记录
     */
    public String moveToAnotherPlace(Address moveToAddress) {
        // …… do something. eg: some business……
        return address.printMoveInfo(moveToAddress);
    }

}