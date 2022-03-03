/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.middle_man.pizzadelivery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * PizzaDeliveryTest
 *
 * @since 2021-07-05
 */
public class PizzaDeliveryTest {
    private PizzaDelivery pizzaDelivery;

    @Test
    void should_have_compensation_given_getOffers_is_late() {
        pizzaDelivery = new PizzaDelivery();
        pizzaDelivery.setTimeOfLateDeliveries(40);

        int compensation = pizzaDelivery.getCompensation();

        assertEquals(2, compensation);
    }

    @Test
    void should_no_compensation_given_getOffers_is_not_late() {
        pizzaDelivery = new PizzaDelivery();
        pizzaDelivery.setTimeOfLateDeliveries(20);

        int compensation = pizzaDelivery.getCompensation();

        assertEquals(0, compensation);
    }
}