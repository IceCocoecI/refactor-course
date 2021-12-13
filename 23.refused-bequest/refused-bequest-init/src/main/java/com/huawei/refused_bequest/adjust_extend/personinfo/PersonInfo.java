/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.adjust_extend.personinfo;

import com.huawei.refused_bequest.adjust_extend.personinfo.constant.Constant;

/**
 * @filename: PersonalInformation
 * @description: 用户个人信息
 */
public abstract class PersonInfo {
    /**
     * 姓名
     */
    protected final String name;

    /**
     * 年龄
     */
    protected final int age;

    /**
     * 身高
     */
    protected final double height;

    /**
     * 体重
     */
    protected final double weight;

    /**
     * 基本退休工资
     */
    protected final int basePensionWage;

    /**
     * 退休时间
     */
    protected final int retiredYears;

    /**
     * 通勤时间
     */
    protected final int commutingTimeEveryDay;

    public PersonInfo(String name, int age, double height, double weight, int basePensionWage, int retiredYears,
        int commutingTimeEveryDay) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.basePensionWage = basePensionWage;
        this.retiredYears = retiredYears;
        this.commutingTimeEveryDay = commutingTimeEveryDay;
    }

    /**
     * 打印格式输出人员信息
     * 
     * @return 人员信息
     */
    public abstract String printInfo();

    /**
     * 计算每月养老工资
     *
     * @return 每月养老工资
     */
    public abstract int calculateMonthlyPensionWage();

    /**
     * 是否达到入学年龄
     * 
     * @return 是否达到入学年龄
     */
    public abstract boolean isReachSchoolAge();

    protected boolean isObese(double rate) {
        return weight / (height * height) >= rate;
    }

}