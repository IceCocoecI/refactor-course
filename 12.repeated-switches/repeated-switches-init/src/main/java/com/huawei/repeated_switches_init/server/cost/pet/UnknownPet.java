package com.huawei.repeated_switches_init.server.cost.pet;

import com.huawei.repeated_switches_init.model.Pet;

/**
 * 功能描述
 *
 * @since 2021-12-08
 */
public class UnknownPet extends PetCosts {
    public UnknownPet(Pet pet) {
        super(pet);
    }

    @Override
    public String getDailyCompanyTime() {
        return "unknown";
    }

    @Override
    public double getDailyPay() {
        return -1;
    }

    @Override
    public String getCleanFrequency() {
        return "unknown";
    }
}
