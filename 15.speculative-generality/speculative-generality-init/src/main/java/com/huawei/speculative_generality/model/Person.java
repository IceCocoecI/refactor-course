/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality.model;

/**
 * 人员健康信息
 *
 * @since 2021-10-27
 */
public class Person {
    private final BodyMassInfo bodyMassInfo;

    private final String name;
    private final int age;
    private final Gender gender;

    public Person(String name, int age, Gender gender, BodyMassInfo bodyMassInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bodyMassInfo = bodyMassInfo;
    }

    /**
     * 获取身高体重相关信息
     * 
     * @return 身高体重相关信息
     */
    public BodyMassInfo getBodyMass() {
        return bodyMassInfo;
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

    public double getHeight() {
        return getBodyMass().getHeight();
    }

    public double getWeight() {
        return getBodyMass().getWeight();
    }

    public double getBodyMassIndex() {
        return getBodyMass().getBodyMassIndex();
    }
}
