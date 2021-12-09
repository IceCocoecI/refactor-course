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
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JULY, 8);

        final HouseData houseData = new HouseData(150, 80000, calendar);

        assertTrue(Math.abs(houseData.getSquare() - 150.0) < 1e-4);
        assertTrue(houseData.isBigHouse());
        assertEquals(6, houseData.calculateHouseAge());
        assertTrue(Math.abs(houseData.getUnitPrice() - 80000.0) < 1e-4);
        assertTrue(Math.abs(houseData.getTotalPrice(tax) - 1.44E7) < 1e-4);
        assertTrue(Math.abs(houseData.getDownPayment(true, tax) - 5040000.0) < 1e-4);
    }
}