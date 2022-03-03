/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches.server.cost;

import com.huawei.repeated_switches.model.Pet;
import com.huawei.repeated_switches.server.cost.pet.CatCosts;
import com.huawei.repeated_switches.server.cost.pet.DogCosts;
import com.huawei.repeated_switches.server.cost.pet.FishCosts;
import com.huawei.repeated_switches.server.cost.pet.PetCosts;
import com.huawei.repeated_switches.server.cost.pet.UnknownPet;

/**
 * 获取宠物耗费精力类工厂
 *
 * @since 2021-06-18
 */
public class PetCostsFactory {
    /**
     * 获取宠物耗费精力类
     *
     * @param pet 宠物信息
     * @return 具体类型宠物实例
     */
    public PetCosts createPetCosts(Pet pet) {
        switch (pet.getSpecies()) {
            case "Dog":
                return new DogCosts(pet);
            case "Cat":
                return new CatCosts(pet);
            case "Fish":
                return new FishCosts(pet);
            default:
                return new UnknownPet(pet);
        }
    }
}
