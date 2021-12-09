
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.huawei.speculative_generality.model.Gender;
import com.huawei.speculative_generality.model.Person;

/**
 * 健康指标计算服务
 *
 * @since 2021-10-19
 */
public class HealthServiceImp {
    public double getBodyFatPercentage(Person person) {
        double bodyFatPercentage =
            1.2 * person.getBodyMassIndex() + 0.23 * person.getAge() - 5.4 - 10.8 * person.getGender().getCode();
        return BigDecimal.valueOf(bodyFatPercentage).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public boolean isObese(Person person) {
        double bodyFatPercentage = getBodyFatPercentage(person);
        if (person.getGender().equals(Gender.FEMALE) && bodyFatPercentage >= 32) {
            return true;
        }
        return person.getGender().equals(Gender.MALE) && bodyFatPercentage >= 25;
    }
}
