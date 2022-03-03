/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches.model;

/**
 * 耗费精力
 *
 * @since 2021-06-18
 */
public class Costs {
    private final String species;

    private final double dailyPay;

    private final String dailyCompanyTime;

    private final String cleanFrequency;

    public Costs(String species, double dailyPay, String dailyCompanyTime, String cleanFrequency) {
        this.species = species;
        this.dailyPay = dailyPay;
        this.dailyCompanyTime = dailyCompanyTime;
        this.cleanFrequency = cleanFrequency;
    }

    @Override
    public String toString() {
        String separator = System.lineSeparator();
        return "species: " + species + separator
            + "dailyPay: " + dailyPay + separator
            + "dailyCompanyTime: " + dailyCompanyTime + separator
            + "cleanFrequency: " + cleanFrequency;
    }
}
