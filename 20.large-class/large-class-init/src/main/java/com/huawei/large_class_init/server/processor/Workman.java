/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.processor;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.huawei.large_class_init.server.processor.enums.Career;
import com.huawei.large_class_init.server.processor.enums.Gender;
import com.huawei.large_class_init.server.processor.model.CareerInfo;
import com.huawei.large_class_init.server.processor.model.Contacts;
import com.huawei.large_class_init.server.processor.workman.Doctor;
import com.huawei.large_class_init.server.processor.workman.InvalidWorkman;
import com.huawei.large_class_init.server.processor.workman.Teacher;

import static com.huawei.large_class_init.server.processor.constant.Constant.LINE_SEPARATOR;

/**
 * 工作人员信息
 *
 * @since 2021-08-25
 */
public abstract class Workman {
    private final String name;

    private final Gender gender;

    protected final CareerInfo careerInfo;
    private final Contacts contacts;

    protected Workman(String name, Gender gender, CareerInfo careerInfo, Contacts contacts) {
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

    protected String generateBasicInfo() {
        return "basic info: " + getBasicInfo() + LINE_SEPARATOR
            + "contact info: " + contacts.getContactInfo() + LINE_SEPARATOR;
    }

    private String getBasicInfo() {
        return LINE_SEPARATOR
            + "\tname: " + name + LINE_SEPARATOR
            + "\tgender: " + gender.name();
    }

    protected double getSalaryAfterYears(double increaseRate, int years) {
        double salaryAfterYears = this.careerInfo.getSalary() * Math.pow(1 + increaseRate, years);
        return BigDecimal.valueOf(salaryAfterYears).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}