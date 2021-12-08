package com.huawei.repeated_switches_init.server.cost.pet;

import com.huawei.repeated_switches_init.model.Pet;
import com.huawei.repeated_switches_init.server.cost.PetCosts;

/**
 * 功能描述
 *
 * @since 2021-12-08
 */
public class DogCosts extends PetCosts {
    public DogCosts(Pet pet) {
        super(pet);
    }

    @Override
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

    @Override
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

    @Override
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
