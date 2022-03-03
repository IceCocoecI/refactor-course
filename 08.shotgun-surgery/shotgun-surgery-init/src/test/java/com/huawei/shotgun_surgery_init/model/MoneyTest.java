/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 货币测试
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
}