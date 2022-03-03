/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.feature_envy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Invoice测试类
 *
 * @version 1.0
 * @since 2021/10/30
 */
class InvoiceTest {
    @Test
    void amount_should_be_sum_of_line_amounts() {
        InvoiceLine line1 = mock(InvoiceLine.class);
        when(line1.getAmount()).thenReturn(BigDecimal.valueOf(3));
        InvoiceLine line2 = mock(InvoiceLine.class);
        when(line2.getAmount()).thenReturn(BigDecimal.valueOf(5));

        Invoice invoice = new Invoice("Buyer1", "Seller1", Arrays.asList(line1, line2));
        BigDecimal amount = invoice.getAmount();
        assertEquals(BigDecimal.valueOf(8), amount);
    }
}
