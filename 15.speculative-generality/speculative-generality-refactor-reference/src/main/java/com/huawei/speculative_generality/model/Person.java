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

    public Person(String name, int age, Gender gender, double height, double weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
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

    /**
     * 计算体脂比
     *
     * @return 体脂比
     */
    public double getBodyMassIndex() {
        return weight / (height * height);
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
