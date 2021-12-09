package com.huawei.lazy_element_init.houseinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import com.huawei.lazy_element_init.houseinfo.housedata.HouseData;

/**
 * House测试类
 *
 * @since 2021-11-08
 */
public class HouseTest {
    @Test
    public void should_get_house_info() {
        final double tax = 0.2;
        final int buyerSalary = 15000;
        final Calendar instance = Calendar.getInstance();
        instance.set(2015, Calendar.JULY, 8);

        final HouseData houseData = new HouseData(150, 80000, instance);
        final House house = new House(houseData.getSquare(), houseData.getUnitPrice(), houseData.getCompletionDate());

        assertTrue(Math.abs(house.getSquare() - 150.0) < 1e-4);
        assertTrue(house.isBigHouse());
        assertEquals(6, house.calculateHouseAge());
        assertTrue(Math.abs(house.getUnitPrice() - 80000.0) < 1e-4);
        assertTrue(Math.abs(house.getTotalPrice(tax) - 1.44E7) < 1e-4);
        assertTrue(Math.abs(house.getDownPayment(true, tax) - 5040000.0) < 1e-4);
    }
}