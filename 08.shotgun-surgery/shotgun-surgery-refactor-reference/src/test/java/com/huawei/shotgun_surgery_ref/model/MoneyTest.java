/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 货币测试类
 *
 * @since 2021-11-02
 */
class MoneyTest {
    @Test
    void constructMoneyExceptionWithBtcCurrency() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(1.2, Currency.BTC));
    }

    @Test
    void constructMoneySuccessWithCnyCurrency() {
        Assertions.assertDoesNotThrow(() -> new Money(1.2, Currency.CNY));
    }

    @Test
    void addMoneyWithSameCurrency() {
        final Money money = initMoney();
        final Money resultMoney = money.add(new Money(500, Currency.CNY));
        Assertions.assertEquals(1500, resultMoney.getAmount());
        Assertions.assertEquals(Currency.CNY, resultMoney.getCurrency());
    }

    @Test
    void addMoneyWithDifferentCurrency() {
        final Money money = initMoney();
        final Money resultMoney = money.add(new Money(100, Currency.USD));
        Assertions.assertEquals(1680, resultMoney.getAmount());
        Assertions.assertEquals(Currency.CNY, resultMoney.getCurrency());
    }

    private Money initMoney() {
        return new Money(1000, Currency.CNY);
    }
}