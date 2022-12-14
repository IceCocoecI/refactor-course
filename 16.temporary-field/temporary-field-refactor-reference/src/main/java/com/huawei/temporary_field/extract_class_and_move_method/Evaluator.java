/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field.extract_class_and_move_method;

/**
 * 账户评估
 *
 * @since 2021-08-05
 */
public class Evaluator {
    private final int maxAsset;

    private final double usageFrequency;

    private final int overdueTimes;

    public Evaluator(int maxAsset, double usageFrequency, int overdueTimes) {
        this.maxAsset = maxAsset;
        this.usageFrequency = usageFrequency;
        this.overdueTimes = overdueTimes;
    }

    /**
     * 整体评估
     *
     * @return 评估结果
     */
    public int evaluateAccount() {
        int evaluatePoint = 60;
        int usageTimes = (int) (usageFrequency * 365) + 1;
        double overdueRate = (double) overdueTimes / usageTimes;
        evaluatePoint -= 10 * overdueRate;
        evaluatePoint += (maxAsset / 100);
        return evaluatePoint;
    }

    /**
     * 消费水平评估
     *
     * @return 评估结果
     */
    public int evaluateConsumptionLevel() {
        return (int) (usageFrequency * 365) - overdueTimes * 3;
    }
}