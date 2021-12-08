package com.huawei.repeated_switches_init.server.cost.pet;

import com.huawei.repeated_switches_init.model.Pet;

/**
 * 功能描述
 *
 * @since 2021-12-08
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
