/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality_ref;

import com.huawei.speculative_generality_ref.model.Gender;
import com.huawei.speculative_generality_ref.model.Person;
import com.huawei.speculative_generality_ref.service.HealthService;

/**
 * 模拟client调用
 *
 * @since 2021-10-19
 */
public class Client {
    public static void main(String[] args) {
        Person person = new Person("John", 18, Gender.MALE, 75.0, 1.80);
        HealthService healthService = new HealthService();
        double bodyFatPercentage = healthService.getBodyFatPercentage(person);
        System.out.println("John body fat percentage is " + bodyFatPercentage);
        System.out.println("is John obese: " + healthService.isObese(person));
    }
}