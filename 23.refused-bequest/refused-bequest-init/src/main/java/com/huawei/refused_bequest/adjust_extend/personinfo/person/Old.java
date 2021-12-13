/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.adjust_extend.personinfo.person;

import com.huawei.refused_bequest.adjust_extend.personinfo.PersonInfo;
import com.huawei.refused_bequest.adjust_extend.personinfo.constant.Constant;

/**
 * @filename: Old
 * @description: 老年人信息
 */
public class Old extends PersonInfo {
    public Old(String name, int age, double height, double weight, int basePensionWage, int retiredYears,
        int commutingTimeEveryDay) {
        super(name, age, height, weight, basePensionWage, retiredYears, commutingTimeEveryDay);
    }

    @Override
    public String printInfo() {
        return "Name: " + name + Constant.LINE_SEPARATOR
            + "IsObese: " + isObese(24.0) + Constant.LINE_SEPARATOR
            + "MonthlyPensionWage: " + calculateMonthlyPensionWage();
    }

    @Override
    public boolean isObese() {
        return weight / (height * height) >= 24.0;
    }

    @Override
    public int calculateMonthlyPensionWage() {
        return (int) (basePensionWage * Math.pow(1.1, retiredYears));
    }

    @Override
    public boolean isReachSchoolAge() {
        return false;
    }
}