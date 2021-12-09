/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality.model;

/**
 * 身高体重相关信息处理
 *
 * @since 2021-10-19
 */
public class BodyMassInfo {
    // 身高，单位m
    private final double height;

    // 体重，单位kg
    private final double weight;

    public BodyMassInfo(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}
