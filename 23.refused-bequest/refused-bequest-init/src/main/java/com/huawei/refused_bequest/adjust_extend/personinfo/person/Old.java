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
    /**
     * 基本退休工资
     */
    protected final int basePensionWage;

    /**
     * 退休时间
     */
    protected final int retiredYears;

    public Old(String name, double height, double weight, int basePensionWage, int retiredYears) {
        super(name, height, weight);
        this.basePensionWage = basePensionWage;
        this.retiredYears = retiredYears;
    }

    @Override
    public String printInfo() {
        return "Name: " + name + Constant.LINE_SEPARATOR
            + "IsObese: " + isObese(24.0) + Constant.LINE_SEPARATOR
            + "MonthlyPensionWage: " + calculateMonthlyPensionWage();
    }

    public int calculateMonthlyPensionWage() {
        return (int) (basePensionWage * Math.pow(1.1, retiredYears));
    }
}