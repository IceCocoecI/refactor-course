/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality.model;

/**
 * 人员健康信息
 *
 * @since 2021-10-27
 */
public class PersonForHealth {
    private final BodyMassInfo bodyMassInfo;

    private final FutureMayUseInfo futureMayUseInfo;
    private final String name;
    private final int age;
    private final Gender gender;

    public PersonForHealth(String name, int age, Gender gender, BodyMassInfo bodyMassInfo,
        FutureMayUseInfo futureMayUseInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bodyMassInfo = bodyMassInfo;
        this.futureMayUseInfo = futureMayUseInfo;
    }

    /**
     * 获取身高体重相关信息
     * 
     * @return 身高体重相关信息
     */
    public BodyMassInfo getBodyMass() {
        return bodyMassInfo;
    }

    public FutureMayUseInfo getFutureMayUseInfo() {
        return futureMayUseInfo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
