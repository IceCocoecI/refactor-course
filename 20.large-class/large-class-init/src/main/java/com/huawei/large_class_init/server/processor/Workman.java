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

import static com.huawei.large_class_init.server.processor.constant.Constant.LINE_SEPARATOR;

/**
 * 工作人员信息
 *
 * @since 2021-08-25
 */
public class Workman {
    private final String name;

    private final Gender gender;

    private final CareerInfo careerInfo;
    private final Contacts contacts;

    public Workman(String name, Gender gender, CareerInfo careerInfo, Contacts contacts) {
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

    private String generateBasicInfo() {
        return "basic info: " + getBasicInfo() + LINE_SEPARATOR
            + "contact info: " + getContactInfo() + LINE_SEPARATOR;
    }

    private String getBasicInfo() {
        return LINE_SEPARATOR
            + "\tname: " + name + LINE_SEPARATOR
            + "\tgender: " + gender.name();
    }

    private String getContactInfo() {
        return LINE_SEPARATOR
            + "\tphoneNumber: " + this.contacts.getPhoneNumber() + LINE_SEPARATOR
            + "\temail: " + this.contacts.getEmail() + LINE_SEPARATOR
            + "\tweChat: " + this.contacts.getWeChat() + LINE_SEPARATOR
            + "\tQQ: " + this.contacts.getQQ();
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