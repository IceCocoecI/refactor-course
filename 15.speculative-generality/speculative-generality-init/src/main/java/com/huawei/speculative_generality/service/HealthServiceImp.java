
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.huawei.speculative_generality.model.Gender;
import com.huawei.speculative_generality.model.PersonForHealth;

/**
 * 健康指标计算服务
 *
 * @since 2021-10-19
 */
public class HealthServiceImp {
    public double getBodyFatPercentage(PersonForHealth person) {
        double bodyFatPercentage =
            1.2 * getBodyMassIndex(person) + 0.23 * person.getAge() - 5.4 - 10.8 * person.getGender().getCode();
        return BigDecimal.valueOf(bodyFatPercentage).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public boolean isObese(PersonForHealth person, double waistHipRatio) {
        double bodyFatPercentage = getBodyFatPercentage(person);
        if (person.getGender().equals(Gender.FEMALE) && bodyFatPercentage >= 32) {
            return true;
        }
        return person.getGender().equals(Gender.MALE) && bodyFatPercentage >= 25;
    }

    private double getBodyMassIndex(PersonForHealth person) {
        return person.getBodyMass().getBodyMassIndex();
    }

    public double getBasalMetabolism(PersonForHealth person) {
        double basalMetabolism;
        if (person.getGender().equals(Gender.FEMALE)) {
            basalMetabolism = 665.1 + 9.6 * person.getBodyMass().getWeight() + 180 * person.getBodyMass().getHeight()
                - 4.7 * person.getAge();
        } else {
            basalMetabolism = 66.5 + 13.8 * person.getBodyMass().getWeight() + 500 * person.getBodyMass().getHeight()
                - 6.8 * person.getAge();
        }
        return BigDecimal.valueOf(basalMetabolism).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
