/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.repeated_switches_init.cilent;

import com.huawei.repeated_switches_init.model.Pet;
import com.huawei.repeated_switches_init.server.KeepPetCosts;

/**
 * client端调用
 *
 * @since 2021-06-17
 */
public class Main {
    public static void main(String[] args) {
        Pet dog = new Pet("Dog", 10, 1);
        System.out.println(new KeepPetCosts().getKeepPetCosts(dog).toString());

        Pet fish = new Pet("Fish", 0.5, 10);
        System.out.println(new KeepPetCosts().getKeepPetCosts(fish).toString());

        Pet cat = new Pet("Cat", 15, 2);
        System.out.println(new KeepPetCosts().getKeepPetCosts(cat).toString());
    }
}
