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
     * 身高
     */
    protected final double height;

    /**
     * 体重
     */
    protected final double weight;

    public PersonInfo(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    /**
     * 打印格式输出人员信息
     * 
     * @return 人员信息
     */
    public abstract String printInfo();

    protected final boolean isObese(double rate) {
        return weight / (height * height) >= rate;
    }

}