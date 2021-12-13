/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.adjust_extend.personinfo.person;

import com.huawei.refused_bequest.adjust_extend.personinfo.PersonInfo;
import com.huawei.refused_bequest.adjust_extend.personinfo.constant.Constant;

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
        return "Name: " + name + Constant.LINE_SEPARATOR
            + "CommutingTimeEveryWeek: " + getCommutingTimeEveryWeek() + Constant.LINE_SEPARATOR
            + "IsObese: " + isObese(25.0);
    }

    private int getCommutingTimeEveryWeek() {
        return commutingTimeEveryDay * 5;
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
