/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field.extract_class_and_move_method;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 账户评估测试
 *
 * @since 2021-08-05
 */
public class EvaluatorTest {
    @Test
    public void should_get_evaluateResult() {
        Evaluator evaluator = new Evaluator(3000, 1.3, 15);

        int accountPoint = evaluator.evaluateAccount();
        int consumptionLevel = evaluator.evaluateConsumptionLevel();

        assertEquals(89, accountPoint);
        assertEquals(429, consumptionLevel);
    }
}