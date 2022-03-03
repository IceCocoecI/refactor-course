/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches.server.cost.pet;

import com.huawei.repeated_switches.model.Pet;

/**
 * 养鱼耗费的精力
 *
 * @since 2021-06-18
 */
public class FishCosts extends PetCosts {
    public FishCosts(Pet pet) {
        super(pet);
    }

    @Override
    public String getDailyCompanyTime() {
        return "20 minutes";
    }

    @Override
    public double getDailyPay() {
        return pet.getDailyFeedingPay() * pet.getQuantity() + 2;
    }

    @Override
    public String getCleanFrequency() {
        return "change the water every 10 days";
    }
}
