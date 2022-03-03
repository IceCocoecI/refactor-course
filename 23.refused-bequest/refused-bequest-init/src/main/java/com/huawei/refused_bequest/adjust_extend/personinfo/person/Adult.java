/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.adjust_extend.personinfo.person;

import com.huawei.refused_bequest.adjust_extend.personinfo.PersonInfo;

/**
 * @filename: Adult
 * @description: 成年人信息
 */
public class Adult extends PersonInfo {
    public Adult(String name, int age, double height, double weight, int basePensionWage, int retiredYears,
        int commutingTimeEveryDay) {
        super(name, age, height, weight, basePensionWage, retiredYears, commutingTimeEveryDay);
    }

    @Override
    public String printInfo() {
        return super.getAdultInfo();
    }

    @Override
    public boolean isObese() {
        return weight / (height * height) >= 25.0;
    }

    @Override
    public int calculateMonthlyPensionWage() {
        return 0;
    }

    @Override
    public boolean isReachSchoolAge() {
        return false;
    }
}
