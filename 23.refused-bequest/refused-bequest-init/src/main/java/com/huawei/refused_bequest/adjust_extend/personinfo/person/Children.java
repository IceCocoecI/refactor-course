/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.adjust_extend.personinfo.person;

import com.huawei.refused_bequest.adjust_extend.personinfo.PersonInfo;
import com.huawei.refused_bequest.adjust_extend.personinfo.constant.Constant;

/**
 * @filename: Children
 * @description: 儿童信息
 */
public class Children extends PersonInfo {
    /**
     * 年龄
     */
    protected final int age;

    public Children(String name, int age, double height, double weight) {
        super(name, height, weight);
        this.age = age;
    }

    @Override
    public String printInfo() {
        return "Name: " + name + Constant.LINE_SEPARATOR
            + "IsObese: " + isObese(28.0) + Constant.LINE_SEPARATOR
            + "IsReachSchoolAge: " + isReachSchoolAge();
    }

    public boolean isReachSchoolAge() {
        return age >= 6;
    }
}
