/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality;

import com.huawei.speculative_generality.model.BodyMassInfo;
import com.huawei.speculative_generality.model.Gender;
import com.huawei.speculative_generality.model.Person;
import com.huawei.speculative_generality.service.HealthServiceImp;

/**
 * 模拟client调用
 *
 * @since 2021-10-19
 */
public class Client {
    public static void main(String[] args) {
        final BodyMassInfo bodyMassInfo = new BodyMassInfo(1.80, 75.0);
        Person person = new Person("John", 18, Gender.MALE, bodyMassInfo.getHeight(), bodyMassInfo.getWeight());
        HealthServiceImp healthServiceImp = new HealthServiceImp();
        double bodyFatPercentage = healthServiceImp.getBodyFatPercentage(person);
        System.out.println("John body fat percentage is " + bodyFatPercentage);
        System.out.println("is John obese: " + healthServiceImp.isObese(person, 0.85));
    }
}
