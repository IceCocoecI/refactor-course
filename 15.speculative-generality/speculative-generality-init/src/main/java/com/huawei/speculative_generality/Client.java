/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality;

import com.huawei.speculative_generality.model.BodyMassInfo;
import com.huawei.speculative_generality.model.Gender;
import com.huawei.speculative_generality.model.PersonForHealth;
import com.huawei.speculative_generality.service.HealthService;
import com.huawei.speculative_generality.service.HealthServiceImp;

/**
 * 模拟client调用
 *
 * @since 2021-10-19
 */
public class Client {
    public static void main(String[] args) {
        final BodyMassInfo bodyMassInfo = new BodyMassInfo(1.80, 75.0);
        PersonForHealth person = new PersonForHealth("John", 18, Gender.MALE, bodyMassInfo, null);
        HealthService<PersonForHealth> healthServiceImp = new HealthServiceImp();
        double bodyFatPercentage = healthServiceImp.getBodyFatPercentage(person);
        System.out.println("John body fat percentage is " + bodyFatPercentage);
        System.out.println("is John obese: " + healthServiceImp.isObese(person, 0.85));
    }
}
