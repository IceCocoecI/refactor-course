/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 币种测试类
 *
 * @since 2021-11-02
 */
class CurrencyTest {

    @Test
    void checkRateUsdToCny() {
        final double rate = Currency.USD.exchangeRateTo(Currency.CNY);
        Assertions.assertEquals(6.8, rate);
    }

    @Test
    void checkRateGbpToCny() {
        final double rate = Currency.GBP.exchangeRateTo(Currency.CNY);
        Assertions.assertEquals(9.6, rate);
    }

    @Test
    void checkRateUsdToGbp() {
        final double rate = Currency.USD.exchangeRateTo(Currency.GBP);
        Assertions.assertEquals(6.8 / 9.6, rate);
    }
}