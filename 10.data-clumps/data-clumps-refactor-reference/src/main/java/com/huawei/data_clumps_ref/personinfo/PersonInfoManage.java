
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_clumps_ref.personinfo;

import com.huawei.data_clumps_ref.personinfo.model.Address;
import com.huawei.data_clumps_ref.personinfo.model.Gender;
import com.huawei.data_clumps_ref.personinfo.model.Name;

/**
 * 用户信息
 *
 * @since 2021-11-03
 */
public class PersonInfoManage {
    private final Name name;

    private final Gender gender;

    private final Address address = new Address();

    public PersonInfoManage(Name name, Gender gender, Address address) {
        // …… do something. eg:check is legal
        this.name = name;
        this.gender = gender;
        this.address.update(address);
    }

    /**
     * 按打印格式获取姓名
     *
     * @return 姓名
     */
    public String getName() {
        // …… do something. eg: auth
        return name.printName();
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
     * 获取地址信息
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
     * @param newAddress 新地址
     */
    public void updateAddress(Address newAddress) {
        // …… do something. eg: auth, check……
        address.update(newAddress);
        newAddress.doNotify();
    }

    /**
     * 按打印格式获取搬移记录
     *
     * @param anotherAddress 目的地址
     */
    public String moveToAnotherPlace(Address anotherAddress) {
        // …… do something. eg: some business……
        return address.printMoveInfo(anotherAddress);
    }
}