/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.middle_man.pizzadelivery;

/**
 * 披萨配送赔付信息
 *
 * @since 2021-06-18
 */
public class PizzaDelivery {
    private int timeOfLateDeliveries;

    /**
     * 获取赔付费用
     *
     * @return int
     */
    public int getCompensation() {
        return getTimeOfLateDeliveries() > 30 ? 2 : 0;
    }

    public void setTimeOfLateDeliveries(int timeOfLateDeliveries) {
        this.timeOfLateDeliveries = timeOfLateDeliveries;
    }

    /**
     * 获取延迟时间
     *
     * @return int
     */
    private int getTimeOfLateDeliveries() {
        return timeOfLateDeliveries;
    }
}
