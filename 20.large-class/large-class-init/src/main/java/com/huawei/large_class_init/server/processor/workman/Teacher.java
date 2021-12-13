/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.processor.workman;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.huawei.large_class_init.server.processor.Workman;
import com.huawei.large_class_init.server.processor.enums.Career;
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
        if (Career.TEACHER.equals(this.careerInfo.getCareer())) {
            return generateTeacherInfo();
        }

        if (Career.DOCTOR.equals(this.careerInfo.getCareer())) {
            return generateDoctorInfo();
        }

        return "invalidPersonInfo";
    }

    private String generateDoctorInfo() {
        return generateBasicInfo()
            + "hospital: " + this.careerInfo.getWorkplace() + LINE_SEPARATOR
            + "doctors' duties: " + showDoctorsDuty() + LINE_SEPARATOR
            + "Salary after 3 years: " + getDoctorSalaryAfterThreeYears();
    }

    private String generateTeacherInfo() {
        return generateBasicInfo()
            + "teachers' hopes: " + showTeachersHope() + LINE_SEPARATOR
            + "school: " + this.careerInfo.getWorkplace() + LINE_SEPARATOR
            + "Salary after 2 years: " + getTeacherSalaryAfterTwoYears();
    }

    private double getDoctorSalaryAfterThreeYears() {
        final double increaseRate = 0.1;
        double salaryAfterYears = this.careerInfo.getSalary() * Math.pow(1 + increaseRate, 3);
        return BigDecimal.valueOf(salaryAfterYears).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private double getTeacherSalaryAfterTwoYears() {
        final double increaseRate = 0.08;
        double salaryAfterYears = this.careerInfo.getSalary() * Math.pow(1 + increaseRate, 2);
        return BigDecimal.valueOf(salaryAfterYears).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private String showDoctorsDuty() {
        return "A doctor's work is to heal and save lives";
    }

    private String showTeachersHope() {
        return "Every student can grow sturdily and get good grades";
    }
}
