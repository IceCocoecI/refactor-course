/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.lazy_element_init.houseinfo.housedata;

/**
 * 旧版本使用的房屋信息数据模型
 *
 * @since 2021-11-08
 */
public class HouseDataOld {
    private final double square;

    private final double unitPrice;

    private final int buildYear;

    public HouseDataOld(double square, double unitPrice, int buildYear) {
        this.square = square;
        this.unitPrice = unitPrice;
        this.buildYear = buildYear;
    }

    public double getSquare() {
        return square;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getBuildYear() {
        return buildYear;
    }
}
