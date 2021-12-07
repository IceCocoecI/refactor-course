/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_init.ticket.play;

import com.huawei.long_parameter_list_init.ticket.constant.Constant;

/**
 * 功能描述 表演项目的相关信息
 *
 * @since 2021-10-27
 */
public class Performance {
    private final String playName;

    private final PlayType playType;

    private final String playDate;

    private final double basicPrice;

    public Performance(String playName, PlayType playType, String playDate, double basicPrice) {
        this.playName = playName;
        this.playType = playType;
        this.playDate = playDate;
        this.basicPrice = basicPrice;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public String getPerformanceInfo() {
        return "playInfo" + Constant.LINE_SEPARATOR
            + "\tplayName: " + playName + Constant.LINE_SEPARATOR
            + "\tplayType: " + playType + Constant.LINE_SEPARATOR
            + "\tdate: " + playDate + Constant.LINE_SEPARATOR;
    }
}
