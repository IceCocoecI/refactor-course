/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches.model;

/**
 * 宠物信息
 *
 * @since 2021-06-18
 */
public class Pet {
    private final String species;

    private final double dailyFeedingPay;

    private final int quantity;

    public Pet(String species, double dailyFeedingPay, int quantity) {
        this.species = species;
        this.dailyFeedingPay = dailyFeedingPay;
        this.quantity = quantity;
    }

    public String getSpecies() {
        return species;
    }

    public double getDailyFeedingPay() {
        return dailyFeedingPay;
    }

    public int getQuantity() {
        return quantity;
    }
}