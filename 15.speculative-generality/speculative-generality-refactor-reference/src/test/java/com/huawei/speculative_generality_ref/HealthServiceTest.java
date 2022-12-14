/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality_ref;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.huawei.speculative_generality_ref.model.Gender;
import com.huawei.speculative_generality_ref.model.Person;
import com.huawei.speculative_generality_ref.service.HealthService;

/**
 * HealthService测试类
 *
 * @since 2021-10-27
 */
class HealthServiceTest {
    private final HealthService healthService = spy(HealthService.class);

    @Nested
    class TestFemale {
        private final Person female =
            new Person("Penny", 28, Gender.FEMALE, 1.65, 50.0);

        @Test
        void testGetBodyFatPercentage() {
            double expect = BigDecimal.valueOf(1.2 * 50.0 / (1.65 * 1.65) + 0.23 * 28 - 5.4)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
            Assertions.assertEquals(expect, healthService.getBodyFatPercentage(female));
        }

        @Test
        void isObeseWhenFemaleBFPIsMoreThan32() {
            doReturn(36.0).when(healthService).getBodyFatPercentage(female);
            Assertions.assertTrue(healthService.isObese(female));
        }

        @Test
        void isNotObeseWhenFemaleBFPIsSmallerThan32() {
            doReturn(30.0).when(healthService).getBodyFatPercentage(female);
            Assertions.assertFalse(healthService.isObese(female));
        }
    }

    @Nested
    class TestMale {
        private final Person male =
            new Person("John", 30, Gender.MALE, 1.80, 75.0);

        @Test
        void testGetBodyFatPercentage() {
            double expect = BigDecimal.valueOf(1.2 * 75.0 / (1.80 * 1.80) + 0.23 * 30 - 5.4 - 10.8)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
            Assertions.assertEquals(expect, healthService.getBodyFatPercentage(male));
        }

        @Test
        void isObeseWhenMaleBFPIsMoreThan25() {
            doReturn(26.0).when(healthService).getBodyFatPercentage(male);
            Assertions.assertTrue(healthService.isObese(male));
        }

        @Test
        void isNotObeseWhenMaleBFPIsSmallerThan25() {
            doReturn(20.0).when(healthService).getBodyFatPercentage(male);
            Assertions.assertFalse(healthService.isObese(male));
        }
    }
}