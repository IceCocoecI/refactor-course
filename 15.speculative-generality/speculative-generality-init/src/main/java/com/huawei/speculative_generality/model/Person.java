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
        return bodyMassInfo.getHeight();
    }

    public double getWeight() {
        return bodyMassInfo.getWeight();
    }

    public double getBodyMassIndex() {
        return bodyMassInfo.getBodyMassIndex();
    }
}
