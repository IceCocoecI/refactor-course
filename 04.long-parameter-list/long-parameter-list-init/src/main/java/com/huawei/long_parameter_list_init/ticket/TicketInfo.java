/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_parameter_list_init.ticket;

import java.math.BigDecimal;

import com.huawei.long_parameter_list_init.ticket.age.AgeLimit;
import com.huawei.long_parameter_list_init.ticket.constant.Constant;
import com.huawei.long_parameter_list_init.ticket.consumer.Consumer;
import com.huawei.long_parameter_list_init.ticket.play.Performance;

/**
 * 功能描述 计算某表演项目的票价, 只有符合年龄要求才可以购买, 儿童票5折, 学生可以打9折, 二者取最小
 *
 * @since 2021-10-18
 */
public class TicketInfo {
    private final double baseDiscount;

    public TicketInfo(double baseDiscount) {
        this.baseDiscount = baseDiscount;
    }

    /**
     * 获取票据信息
     * 
     *
     * @param consumer
     * @param performance 演出信息
     * @param ageLimit
     * @return 票据信息
     */
    public String getTicketInfo(Consumer consumer, Performance performance, AgeLimit ageLimit) {
        if ((consumer.getAge() < ageLimit.getAgeFloor() || consumer.getAge() > ageLimit.getAgeCeiling())) {
            throw new IllegalArgumentException("age is out of valid range, cannot buy ticket!");
        }

        return getPerformanceInfo(performance)
            + consumer.getConsumerInfo()
            + getPriceInfo(consumer, performance);
    }

    private String getPriceInfo(Consumer consumer, Performance performance) {
        final double discount = getDiscount(consumer);
        final double ticketPrice = getTicketPrice(discount, performance.getBasicPrice());
        return "priceInfo" + Constant.LINE_SEPARATOR
            + "\tprice: " + ticketPrice + Constant.LINE_SEPARATOR
            + "\tdiscount: " + discount + Constant.LINE_SEPARATOR;
    }

    private double getDiscount(Consumer consumer) {
        double childDiscount = calculateChildDiscount(consumer.isChild());
        double studentDiscount = calculateStudentDiscount(consumer.isStudent());
        return BigDecimal.valueOf(Math.min(childDiscount, studentDiscount))
            .setScale(2, BigDecimal.ROUND_HALF_UP)
            .doubleValue();
    }

    private double calculateStudentDiscount(boolean isStudent) {
        return isStudent ? 0.9 * baseDiscount : baseDiscount;
    }

    private double calculateChildDiscount(boolean isChild) {
        return isChild ? 0.5 : baseDiscount;
    }

    private double getTicketPrice(double discount, double basicPrice) {
        return BigDecimal.valueOf(discount * basicPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private String getPerformanceInfo(Performance performance) {
        return "playInfo" + Constant.LINE_SEPARATOR
            + "\tplayName: " + performance.getPlayName() + Constant.LINE_SEPARATOR
            + "\tplayType: " + performance.getPlayType() + Constant.LINE_SEPARATOR
            + "\tdate: " + performance.getPlayDate() + Constant.LINE_SEPARATOR;
    }
}
