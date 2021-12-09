/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.lazy_element_init.houseinfo.housedata;

import java.util.Calendar;

/**
 * 房屋信息数据模型
 *
 * @since 2021-11-08
 */
public class HouseData {
    public static final int BIG_HOUSE_AREA = 140;
    public static final double FIRST_HOUSE_PAY_RATE = 0.35;
    public static final double NOT_FIRST_HOUSE_PAY_RATE = 0.7;
    private final double square;

    private final double unitPrice;

    private final Calendar completionDate;

    public HouseData(double square, double unitPrice, Calendar completionDate) {
        this.square = square;
        this.unitPrice = unitPrice;
        this.completionDate = completionDate;
    }

    public double getSquare() {
        return square;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Calendar getCompletionDate() {
        return completionDate;
    }
}
