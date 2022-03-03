/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.feature_envy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

/**
 * InvoiceLine测试类
 *
 * @version 1.0
 * @since 2021/10/30
 */
class InvoiceLineTest {
    @Test
    void amount_should_be_product_of_price_and_quantity() {
        InvoiceLine line = new InvoiceLine("Product", BigDecimal.valueOf(3), BigDecimal.valueOf(5));
        BigDecimal amount = line.getAmount();
        assertEquals(BigDecimal.valueOf(15), amount);
    }

    @Test
    void amount_should_be_product_of_price_and_quantity_even_if_quantity_is_negative() {
        InvoiceLine line = new InvoiceLine("Product", BigDecimal.valueOf(3), BigDecimal.valueOf(-5));
        BigDecimal amount = line.getAmount();
        assertEquals(BigDecimal.valueOf(-15), amount);
    }
}