/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_init.ticket.age;

import com.huawei.long_parameter_list_init.ticket.consumer.Consumer;

/**
 * 功能描述 买票的年龄限制
 *
 * @since 2021-10-18
 */
public class AgeLimit {
    // 年龄下限
    private final int ageFloor;

    // 年龄上限
    private final int ageCeiling;

    public AgeLimit(int ageFloor, int ageCeiling) {
        this.ageFloor = ageFloor;
        this.ageCeiling = ageCeiling;
    }

    public void checkAge(Consumer consumer) {
        if ((consumer.getAge() < ageFloor || consumer.getAge() > ageCeiling)) {
            throw new IllegalArgumentException("age is out of valid range, cannot buy ticket!");
        }
    }
}
