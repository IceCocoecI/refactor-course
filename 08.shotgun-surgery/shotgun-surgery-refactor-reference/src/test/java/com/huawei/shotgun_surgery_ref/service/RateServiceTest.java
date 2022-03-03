/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.huawei.shotgun_surgery_ref.model.Currency;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * 汇率服务测试
 *
 * @since 2021-11-18
 */
class RateServiceTest {
    @Test
    void should_get_currencyDoubleMap() {
        RateService rateService = new RateService();

        Map<Currency, Double> currencyDoubleMap = rateService.queryAllRatesToCny();

        assertEquals(4, currencyDoubleMap.size());
        assertEquals(9.6, currencyDoubleMap.get(Currency.GBP));
        assertEquals(1.0, currencyDoubleMap.get(Currency.CNY));
        assertEquals(6.8, currencyDoubleMap.get(Currency.USD));
        assertEquals(60000.0, currencyDoubleMap.get(Currency.BTC));
    }

    @Test
    void should_get_exchangeRate() {
        RateService rateService = new RateService();

        double exchangeRate = rateService.queryExchangeRate(Currency.GBP, Currency.USD);

        assertTrue(Math.abs(exchangeRate - 1.41) < 1e-2);
    }
}