/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field_init.extract_class_and_move_method;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
        final Evaluator evaluator = getEvaluator();

        int accountPoint = evaluator.evaluateAccount();
        int consumptionLevel = evaluator.evaluateConsumptionLevel();

        assertEquals(89, accountPoint);
        assertEquals(429, consumptionLevel);
    }

    private Evaluator getEvaluator() {
        return new Evaluator(3000, 1.3, 15);
//        final Evaluator evaluator = new Evaluator();
//        evaluator.setMaxAsset(3000);
//        evaluator.setUsageFrequency(1.3);
//        evaluator.setOverdueTimes(15);
//        return evaluator;
    }
}
