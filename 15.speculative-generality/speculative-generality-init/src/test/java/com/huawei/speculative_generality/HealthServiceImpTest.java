
package com.huawei.speculative_generality;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.huawei.speculative_generality.model.BodyMassInfo;
import com.huawei.speculative_generality.model.Gender;
import com.huawei.speculative_generality.model.PersonForHealth;
import com.huawei.speculative_generality.service.HealthService;
import com.huawei.speculative_generality.service.HealthServiceImp;

/**
 * HealthService测试类
 *
 * @since 2021-10-27
 */
class HealthServiceImpTest {
    private final HealthService<PersonForHealth> healthService = spy(HealthServiceImp.class);

    @Nested
    class TestFemale {
        private final BodyMassInfo bodyMassInfo = new BodyMassInfo(1.65, 50.0);
        private final PersonForHealth female =
            new PersonForHealth("Penny", 28, Gender.FEMALE, bodyMassInfo, null);

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
            Assertions.assertTrue(healthService.isObese(female, 0));
        }

        @Test
        void isNotObeseWhenFemaleBFPIsSmallerThan32() {
            doReturn(30.0).when(healthService).getBodyFatPercentage(female);
            Assertions.assertFalse(healthService.isObese(female, 0));
        }

        @Test
        void getBasalMetabolism() {
            double expect = 665.1 + 9.6 * 50.0 + 180 * 1.65 - 4.7 * 28;
            Assertions.assertEquals(expect, healthService.getBasalMetabolism(female));
        }
    }

    @Nested
    class TestMale {
        private final BodyMassInfo bodyMassInfo = new BodyMassInfo(1.80, 75.0);
        private final PersonForHealth male =
            new PersonForHealth("John", 30, Gender.MALE, bodyMassInfo, null);

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
            Assertions.assertTrue(healthService.isObese(male, 0));
        }

        @Test
        void isNotObeseWhenMaleBFPIsSmallerThan25() {
            doReturn(20.0).when(healthService).getBodyFatPercentage(male);
            Assertions.assertFalse(healthService.isObese(male, 0));
        }

        @Test
        void getBasalMetabolism() {
            double expect = 66.5 + 13.8 * 75.0 + 500 * 1.80 - 6.8 * 30;
            Assertions.assertEquals(expect, healthService.getBasalMetabolism(male));
        }
    }
}