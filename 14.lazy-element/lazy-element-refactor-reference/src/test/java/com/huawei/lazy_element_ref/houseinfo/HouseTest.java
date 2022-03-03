/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.lazy_element_ref.houseinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

/**
 * House测试类
 *
 * @since 2021-11-08
 */
public class HouseTest {
    @Test
    public void should_get_house_info() {
        final double tax = 0.2;
        final Calendar instance = Calendar.getInstance();
        instance.set(2015, Calendar.JULY, 8);

        final House house = new House(150, 80000, instance);

        assertTrue(Math.abs(house.getSquare() - 150.0) < 1e-4);
        assertTrue(house.isBigHouse());
        assertEquals(6, house.calculateHouseAge());
        assertTrue(Math.abs(house.getUnitPrice() - 80000.0) < 1e-4);
        assertTrue(Math.abs(house.getTotalPrice(tax) - 1.44E7) < 1e-4);
        assertTrue(Math.abs(house.getDownPayment(true, tax) - 5040000.0) < 1e-4);
    }
}