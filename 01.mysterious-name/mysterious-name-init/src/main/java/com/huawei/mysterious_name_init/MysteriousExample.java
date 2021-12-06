/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.mysterious_name_init;

public class MysteriousExample {
    public int calculateAmount(Performance performance, Type type) {
        switch (type) {
            case TYPE1:
                return resfortype1(performance);
            case TYPE2:
                return resfortype2(performance);
            default:
                throw new IllegalArgumentException("Illegal type : " + type);
        }
    }

    private int resfortype1(Performance performance) {
        int totalAmount = 40000;
        if (performance.getAudienceNum() > 30) {
            totalAmount += 1000 * (performance.getAudienceNum() - 30);
        }
        return totalAmount;
    }

    private int resfortype2(Performance performance) {
        int totalAmount = 30000;
        if (performance.getAudienceNum() > 20) {
            totalAmount += 1000 + 500 * (performance.getAudienceNum() - 20);
        }
        return totalAmount;
    }
}
