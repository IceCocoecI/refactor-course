/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.server.processor.model;

import com.huawei.large_class.server.processor.enums.Career;

/**
 * 职业信息
 *
 * @since 2021-08-25
 */
public class CareerInfo {
    private final String workplace;

    private final Career career;

    private final double salary;

    public CareerInfo(Career career, String workplace, double salary) {
        this.workplace = workplace;
        this.career = career;
        this.salary = salary;
    }

    public String getWorkplace() {
        return workplace;
    }

    public Career getCareer() {
        return career;
    }

    public double getSalary() {
        return salary;
    }
}