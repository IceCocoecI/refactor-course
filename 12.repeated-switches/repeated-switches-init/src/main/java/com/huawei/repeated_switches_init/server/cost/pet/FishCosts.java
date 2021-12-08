package com.huawei.repeated_switches_init.server.cost.pet;

import com.huawei.repeated_switches_init.model.Pet;

/**
 * 功能描述
 *
 * @since 2021-12-08
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
