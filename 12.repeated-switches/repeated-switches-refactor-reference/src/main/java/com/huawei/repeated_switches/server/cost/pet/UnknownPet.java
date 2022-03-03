/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches.server.cost.pet;

import com.huawei.repeated_switches.model.Pet;

/**
 * 未知类型
 *
 * @since 2021-06-18
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
