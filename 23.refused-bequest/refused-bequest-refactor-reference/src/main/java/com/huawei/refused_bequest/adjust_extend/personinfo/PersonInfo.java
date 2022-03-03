/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.adjust_extend.personinfo;

/**
 * @filename: PersonalInformation
 * @description: 用户个人信息
 */
public abstract class PersonInfo {
    /**
     * 姓名
     */
    protected final String name;

    private final double height;

    private final double weight;

    public PersonInfo(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    /**
     * 获取打印格式的个人信息
     * 
     * @return 个人信息
     */
    public abstract String printInfo();

    /**
     * 是否肥胖
     * 
     * @param rate 比率范围
     * @return 是否肥胖
     */
    protected final boolean isObese(double rate) {
        return weight / (height * height) >= rate;
    }
}
