package com.huawei.repeated_switches_init.server.cost;

import com.huawei.repeated_switches_init.model.Pet;
import com.huawei.repeated_switches_init.server.cost.pet.CatCosts;
import com.huawei.repeated_switches_init.server.cost.pet.DogCosts;
import com.huawei.repeated_switches_init.server.cost.pet.FishCosts;
import com.huawei.repeated_switches_init.server.cost.pet.PetCosts;
import com.huawei.repeated_switches_init.server.cost.pet.UnknownPet;

/**
 * 功能描述
 *
 * @since 2021-12-08
 */
public class PetCostsFactory {
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
