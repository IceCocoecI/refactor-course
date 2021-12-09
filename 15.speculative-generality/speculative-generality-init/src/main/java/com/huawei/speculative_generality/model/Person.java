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

    private final String name;
    private final int age;
    private final Gender gender;
    private final double height;
    private final double weight;

    public Person(String name, int age, Gender gender, BodyMassInfo bodyMassInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        height = bodyMassInfo.getHeight();
        weight = bodyMassInfo.getWeight();
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
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBodyMassIndex() {
        return weight / (height * height);
    }
}
