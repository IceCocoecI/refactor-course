/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.server.processor;

import static com.huawei.large_class.server.processor.constant.Constant.LINE_SEPARATOR;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.huawei.large_class.server.processor.enums.Gender;
import com.huawei.large_class.server.processor.model.CareerInfo;
import com.huawei.large_class.server.processor.model.Contacts;

/**
 * 工作人员信息
 *
 * @since 2021-08-25
 */
public abstract class Workman {
    private final String name;

    private final Gender gender;

    /**
     * 职业信息
     */
    protected final CareerInfo careerInfo;

    private final Contacts contacts;

    protected Workman(String name, Gender gender, Contacts contacts, CareerInfo careerInfo) {
        this.name = name;
        this.gender = gender;
        this.contacts = contacts;
        this.careerInfo = careerInfo;
    }

    /**
     * 生成人员信息
     *
     * @return 人员信息
     */
    public abstract String generatePersonInfo();

    /**
     * 生成人员基本信息
     * 
     * @return 人员基本信息
     */
    protected String generateBasicInfo() {
        return "basic info: " + getBasicInfo() + LINE_SEPARATOR
            + "contact info: " + contacts.getContactInfo() + LINE_SEPARATOR;
    }

    private String getBasicInfo() {
        return LINE_SEPARATOR
            + "\tname: " + name + LINE_SEPARATOR
            + "\tgender: " + gender.name();
    }

    /**
     * 计算几年后的工资
     * 
     * @param increaseRate 工资年涨幅
     * @param years 年数
     * @return 几年后的工资
     */
    protected double getSalaryAfterYears(double increaseRate, int years) {
        double salaryAfterYears = this.careerInfo.getSalary() * Math.pow(1 + increaseRate, years);
        return BigDecimal.valueOf(salaryAfterYears).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}