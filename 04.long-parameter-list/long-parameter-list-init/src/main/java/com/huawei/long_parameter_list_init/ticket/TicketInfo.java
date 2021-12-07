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
            + getConsumerInfo(consumer)
            + getPriceInfo(consumer.isChild(), consumer.isStudent(), performance.getBasicPrice());
    }

    private String getConsumerInfo(Consumer consumer) {
        return getConsumerInfo(consumer.getName(), consumer.getAge(), consumer.isStudent(), consumer.isChild());
    }

    private String getPriceInfo(boolean isChild, boolean isStudent, double basicPrice) {
        final double discount = getDiscount(isStudent, isChild);
        final double ticketPrice = getTicketPrice(discount, basicPrice);
        return "priceInfo" + Constant.LINE_SEPARATOR
            + "\tprice: " + ticketPrice + Constant.LINE_SEPARATOR
            + "\tdiscount: " + discount + Constant.LINE_SEPARATOR;
    }

    private double getDiscount(boolean isStudent, boolean isChild) {
        double childDiscount = calculateDiscount("Child", isChild, isStudent);
        double studentDiscount = calculateDiscount("Student", isChild, isStudent);
        return BigDecimal.valueOf(Math.min(childDiscount, studentDiscount))
            .setScale(2, BigDecimal.ROUND_HALF_UP)
            .doubleValue();
    }

    private double calculateDiscount(String discountType, boolean isChild, boolean isStudent) {
        if ("Child".equals(discountType) && isChild) {
            return 0.5;
        }
        if ("Student".equals(discountType) && isStudent) {
            return 0.9 * baseDiscount;
        }
        return baseDiscount;
    }

    private double getTicketPrice(double discount, double basicPrice) {
        return BigDecimal.valueOf(discount * basicPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private String getConsumerInfo(String name, int age, boolean isStudent, boolean isChild) {
        return "consumerInfo" + Constant.LINE_SEPARATOR
            + "\tname: " + name + Constant.LINE_SEPARATOR
            + "\tage: " + age + Constant.LINE_SEPARATOR
            + "\tisStudent: " + isStudent + Constant.LINE_SEPARATOR
            + "\tisChild: " + isChild + Constant.LINE_SEPARATOR;
    }

    private String getPerformanceInfo(Performance performance) {
        return "playInfo" + Constant.LINE_SEPARATOR
            + "\tplayName: " + performance.getPlayName() + Constant.LINE_SEPARATOR
            + "\tplayType: " + performance.getPlayType() + Constant.LINE_SEPARATOR
            + "\tdate: " + performance.getPlayDate() + Constant.LINE_SEPARATOR;
    }
}
