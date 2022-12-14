/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field_init.extract_class_and_move_method;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.huawei.temporary_field_init.extract_class_and_move_method.Account;

/**
 * 账户信息测试
 *
 * @since 2021-08-05
 */
public class TestAccount {
    @Test
    public void should_get_balance() {
        Account account = new Account("zhangSan", "123456", 100);

        account.addToBalance(10);
        account.deductBalance(5);
        int balance = account.getBalance();

        assertEquals("zhangSan", account.getName());
        assertEquals("123456", account.getCardId());
        assertEquals(105, balance);
    }

    @Test
    public void should_get_evaluateResult() {
        Account account = new Account("zhangSan", "123456", 100);
        account.setMaxAsset(3000);
        account.setUsageFrequency(1.3);
        account.setOverdueTimes(15);

        int accountPoint = account.evaluateAccount();
        int consumptionLevel = account.evaluateConsumptionLevel();

        assertEquals(89, accountPoint);
        assertEquals(429, consumptionLevel);
    }
}
