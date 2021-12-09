/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.lazy_element_init.houseinfo;

import java.util.Calendar;

import com.huawei.lazy_element_init.houseinfo.housedata.HouseData;

/**
 * 房屋信息处理
 *
 * @since 2021-11-08
 */
public class House {
    private static final double FIRST_HOUSE_PAY_RATE = 0.35;

    private static final double NOT_FIRST_HOUSE_PAY_RATE = 0.7;

    /**
     * 房屋信息数据
     */
    protected final HouseData houseData;


    public House(HouseData houseData) {
        this.houseData = houseData;
    }

    /**
     * 计算房屋总价
     * 
     * @param tax 税率
     * @return 总价
     */
    public double getTotalPrice(double tax) {
        return houseData.getSquare() * houseData.getUnitPrice() * (1 + tax);
    }

    /**
     * 计算购房首付款
     * 
     * @param isFirstHouse 是否首套房
     * @param tax 税率
     * @return 购房首付款
     */
    public double getDownPayment(boolean isFirstHouse, double tax) {
        return isFirstHouse ? FIRST_HOUSE_PAY_RATE * getTotalPrice(tax) : NOT_FIRST_HOUSE_PAY_RATE * getTotalPrice(tax);
    }

    /**
     * 计算房龄
     * 
     * @return 房龄
     */
    public int calculateHouseAge() {
        return doCalculateHouseAge();
    }

    /**
     * 获取房屋面积
     * 
     * @return 房屋面积
     */
    public double getSquare() {
        return houseData.getSquare();
    }

    /**
     * 获取房屋单价
     * 
     * @return 单价
     */
    public double getUnitPrice() {
        return houseData.getUnitPrice();
    }

    private int doCalculateHouseAge() {
        final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - houseData.getCompletionDate().get(Calendar.YEAR);
    }

}
