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
    public Children(String name, int age, double height, double weight, int basePensionWage, int retiredYears,
        int commutingTimeEveryDay) {
        super(name, age, height, weight, basePensionWage, retiredYears, commutingTimeEveryDay);
    }

    @Override
    public String printInfo() {
        return "Name: " + name + Constant.LINE_SEPARATOR
            + "IsObese: " + isObese(28.0) + Constant.LINE_SEPARATOR
            + "IsReachSchoolAge: " + isReachSchoolAge();
    }

    @Override
    public int calculateMonthlyPensionWage() {
        return 0;
    }

    @Override
    public boolean isReachSchoolAge() {
        return age >= 6;
    }
}
