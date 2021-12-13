/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.interfaces.dto;

import com.huawei.large_class_init.server.processor.enums.Career;
import com.huawei.large_class_init.server.processor.enums.Gender;
import com.huawei.large_class_init.server.processor.model.CareerInfo;

/**
 * 工作人员信息数据传输对象
 *
 * @since 2021-08-25
 */
public class WorkmanInfoDto {
    private String name;

    private Gender gender;

    private String phoneNumber;

    private String email;

    private String workplace;

    private Career career;

    private double salary;

    private String weChat;

    private String QQ;

    public String getName() {
        return name;
    }

    public WorkmanInfoDto setName(String name) {
        this.name = name;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public WorkmanInfoDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public WorkmanInfoDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WorkmanInfoDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public WorkmanInfoDto setWorkplace(String workplace) {
        this.workplace = workplace;
        return this;
    }

    public WorkmanInfoDto setCareer(Career career) {
        this.career = career != null ? career : Career.INVALID;
        return this;
    }

    public WorkmanInfoDto setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public String getWeChat() {
        return weChat;
    }

    public WorkmanInfoDto setWeChat(String weChat) {
        this.weChat = weChat;
        return this;
    }

    public String getQQ() {
        return QQ;
    }

    public WorkmanInfoDto setQQ(String QQ) {
        this.QQ = QQ;
        return this;
    }

    /**
     * 获取职业信息
     *
     * @return 职业信息
     */
    public CareerInfo getCareerInfo() {
        return new CareerInfo(career, workplace, salary);
    }
}
