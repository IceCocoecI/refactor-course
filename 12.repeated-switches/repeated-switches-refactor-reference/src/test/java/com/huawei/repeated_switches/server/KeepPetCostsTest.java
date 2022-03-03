/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches.server;

import org.junit.jupiter.api.Test;

import com.huawei.repeated_switches.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * KeepPetCosts测试类
 *
 * @since 2021-06-21
 */
class KeepPetCostsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void should_got_dogCosts_when_getKeepPetCosts_given_pet_is_dog() {
        Pet dog = new Pet("Dog", 10, 1);

        String result = new KeepPetCosts().getKeepPetCosts(dog).toString();

        assertEquals("species: Dog" + LINE_SEPARATOR +
            "dailyPay: 15.0" + LINE_SEPARATOR +
            "dailyCompanyTime: 150 minutes" + LINE_SEPARATOR +
            "cleanFrequency: wash every 2 weeks", result);
    }

    @Test
    void should_got_fishCosts_when_getKeepPetCosts_given_pet_is_fish() {
        Pet fish = new Pet("Fish", 0.5, 10);

        String result = new KeepPetCosts().getKeepPetCosts(fish).toString();

        assertEquals("species: Fish" + LINE_SEPARATOR +
            "dailyPay: 7.0" + LINE_SEPARATOR +
            "dailyCompanyTime: 20 minutes" + LINE_SEPARATOR +
            "cleanFrequency: change the water every 10 days", result);
    }

    @Test
    void should_got_catCosts_when_getKeepPetCosts_given_pet_is_cat() {
        Pet cat = new Pet("Cat", 15, 2);

        String result = new KeepPetCosts().getKeepPetCosts(cat).toString();

        System.out.println(result);
        assertEquals("species: Cat" + LINE_SEPARATOR +
            "dailyPay: 36.0" + LINE_SEPARATOR +
            "dailyCompanyTime: 120 minutes" + LINE_SEPARATOR +
            "cleanFrequency: wash every 6 weeks", result);
    }

    @Test
    void should_got_unknownCosts_when_getKeepPetCosts_given_pet_is_unknown() {
        Pet unknownPet = new Pet("unknown", 0, 0);

        String result = new KeepPetCosts().getKeepPetCosts(unknownPet).toString();

        assertEquals("species: unknown" + LINE_SEPARATOR +
            "dailyPay: -1.0" + LINE_SEPARATOR +
            "dailyCompanyTime: unknown" + LINE_SEPARATOR +
            "cleanFrequency: unknown", result);
    }
}