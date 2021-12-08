/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches_init.server.cost;

import com.huawei.repeated_switches_init.model.Pet;
import com.huawei.repeated_switches_init.server.cost.pet.CatCosts;
import com.huawei.repeated_switches_init.server.cost.pet.DogCosts;
import com.huawei.repeated_switches_init.server.cost.pet.FishCosts;
import com.huawei.repeated_switches_init.server.cost.pet.UnknownPet;

/**
 * 饲养宠物耗费精力
 *
 * @since 2021-06-18
 */
public class PetCosts {
    protected final Pet pet;

    protected PetCosts(Pet pet) {
        this.pet = pet;
    }

    /**
     * 每天需要陪伴的时间
     * 
     * @return 每天需要陪伴的时间
     */
    public String getDailyCompanyTime() {
        switch (pet.getSpecies()) {
            case "Dog":
                return 90 + 60 * pet.getQuantity() + " minutes";
            case "Cat":
                return 60 * pet.getQuantity() + " minutes";
            case "Fish":
                return "20 minutes";
            default:
                return "unknown";
        }
    }

    /**
     * 每天需要花费的金钱
     * 
     * @return 每天需要花费的金钱
     */
    public double getDailyPay() {
        switch (pet.getSpecies()) {
            case "Dog":
                return pet.getDailyFeedingPay() * pet.getQuantity() * 1.5;
            case "Cat":
                return pet.getDailyFeedingPay() * pet.getQuantity() * 1.2;
            case "Fish":
                return pet.getDailyFeedingPay() * pet.getQuantity() + 2;
            default:
                return -1;
        }
    }

    /**
     * 清理频率
     * 
     * @return 清理频率
     */
    public String getCleanFrequency() {
        switch (pet.getSpecies()) {
            case "Dog":
                return "wash every 2 weeks";
            case "Cat":
                return "wash every 6 weeks";
            case "Fish":
                return "change the water every 10 days";
            default:
                return "unknown";
        }
    }
}