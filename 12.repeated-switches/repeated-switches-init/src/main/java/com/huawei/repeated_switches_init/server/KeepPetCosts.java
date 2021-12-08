/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches_init.server;

import com.huawei.repeated_switches_init.model.Costs;
import com.huawei.repeated_switches_init.model.Pet;
import com.huawei.repeated_switches_init.server.cost.pet.PetCosts;
import com.huawei.repeated_switches_init.server.cost.PetCostsFactory;

/**
 * 饲养宠物耗费的精力
 *
 * @since 2021-06-18
 */
public class KeepPetCosts {
    /**
     * 获取饲养宠物耗费的精力
     * 
     * @param pet 宠物信息
     * @return 耗费的精力
     */
    public Costs getKeepPetCosts(Pet pet) {
        PetCosts petCosts = new PetCostsFactory().createPetCosts(pet);
        return new Costs(pet.getSpecies(), petCosts.getDailyPay(),
            petCosts.getDailyCompanyTime(), petCosts.getCleanFrequency());
    }
}
