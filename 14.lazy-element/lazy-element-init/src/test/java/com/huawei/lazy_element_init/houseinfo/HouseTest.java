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

        final BigHouse bigHouse = new BigHouse(new HouseData(150, 80000, instance));

        assertTrue(Math.abs(bigHouse.getSquare() - 150.0) < 1e-4);
        assertTrue(bigHouse.isBigHouse());
        assertEquals(Calendar.getInstance().get(Calendar.YEAR) - 2015, bigHouse.calculateHouseAge());
        assertTrue(Math.abs(bigHouse.getUnitPrice() - 80000.0) < 1e-4);
        assertTrue(Math.abs(bigHouse.getTotalPrice(tax) - 1.44E7) < 1e-4);
        assertTrue(Math.abs(bigHouse.getDownPayment(true, tax, buyerSalary) - 5040000.0) < 1e-4);
    }
}