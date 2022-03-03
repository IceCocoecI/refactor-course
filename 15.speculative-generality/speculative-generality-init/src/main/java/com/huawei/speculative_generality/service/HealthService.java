/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality.service;

import com.huawei.speculative_generality.model.Animal;

/**
 * 健康指标计算服务接口
 *
 * @since 2021-10-19
 */
public interface HealthService<T extends Animal> {
    /**
     * 根据BMI指数、年龄和性别估算体脂比
     * 
     * @return 体脂比,单位%
     */
    double getBodyFatPercentage(T animal);

    /**
     * 根据体脂比和性别判断是否肥胖
     * 
     * @return 是否肥胖
     */
    boolean isObese(T animal, double waistHipRatio);

    /**
     * 根据性别、年龄、身高和体重计算的基础代谢量
     * 
     * @param animal person
     * @return 基础代谢量，单位kcal
     */
    double getBasalMetabolism(T animal);
}
