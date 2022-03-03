/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches.server.cost.pet;

import com.huawei.repeated_switches.model.Pet;

/**
 * 饲养猫耗费的精力
 *
 * @since 2021-06-18
 */
public class CatCosts extends PetCosts {
    public CatCosts(Pet pet) {
        super(pet);
    }

    @Override
    public String getDailyCompanyTime() {
        return 60 * pet.getQuantity() + " minutes";
    }

    @Override
    public double getDailyPay() {
        return pet.getDailyFeedingPay() * pet.getQuantity() * 1.2;
    }

    @Override
    public String getCleanFrequency() {
        return "wash every 6 weeks";
    }
}
