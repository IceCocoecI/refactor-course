/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches.client;

import com.huawei.repeated_switches.model.Pet;
import com.huawei.repeated_switches.server.KeepPetCosts;

/**
 * 功能描述
 *
 * @since 2021-06-17
 */
public class Main {
    public static void main(String[] args) {
        Pet cat = new Pet("Cat", 15, 2);
        System.out.println(new KeepPetCosts().getKeepPetCosts(cat).toString());

        Pet fish = new Pet("Fish", 0.5, 10);
        System.out.println(new KeepPetCosts().getKeepPetCosts(fish).toString());

        Pet dog = new Pet("Dog", 10, 1);
        System.out.println(new KeepPetCosts().getKeepPetCosts(dog).toString());
    }
}
