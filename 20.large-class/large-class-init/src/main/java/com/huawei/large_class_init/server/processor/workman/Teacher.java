/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.processor.workman;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.huawei.large_class_init.server.processor.Workman;
import com.huawei.large_class_init.server.processor.enums.Gender;
import com.huawei.large_class_init.server.processor.model.CareerInfo;
import com.huawei.large_class_init.server.processor.model.Contacts;

import static com.huawei.large_class_init.server.processor.constant.Constant.LINE_SEPARATOR;

/**
 * 功能描述
 *
 * @since 2021-12-13
 */
public class Teacher extends Workman {
    public Teacher(String name, Gender gender, CareerInfo careerInfo, Contacts contacts) {
        super(name, gender, careerInfo, contacts);
    }

    @Override
    public String generatePersonInfo() {
        return generateBasicInfo()
            + "teachers' hopes: " + showTeachersHope() + LINE_SEPARATOR
            + "school: " + this.careerInfo.getWorkplace() + LINE_SEPARATOR
            + "Salary after 2 years: " + getTeacherSalaryAfterTwoYears();
    }

    private double getTeacherSalaryAfterTwoYears() {
        final double increaseRate = 0.08;
        final int years = 2;
        return getSalaryAfterYears(increaseRate, years);
    }

    private String showTeachersHope() {
        return "Every student can grow sturdily and get good grades";
    }
}
