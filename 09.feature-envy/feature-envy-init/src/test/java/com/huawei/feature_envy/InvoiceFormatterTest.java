/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.feature_envy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * InvoiceFormatter测试类
 *
 * @version 1.0
 * @since 2021/10/30
 */
class InvoiceFormatterTest {
    private static Invoice createInvoice() {
        InvoiceLine line0 = new InvoiceLine("Product1", BigDecimal.ONE, BigDecimal.valueOf(2));
        InvoiceLine line1 = new InvoiceLine("Product2", BigDecimal.valueOf(0.1), BigDecimal.valueOf(10));
        Invoice invoice = new Invoice("Abc Inc.", "Xyz Inc.", Arrays.asList(line0, line1));
        return invoice;
    }

    @Test
    void invoice_should_formatted_with_precision_equals_zero_when_given_zero() {
        InvoiceFormatter formatter = new InvoiceFormatter(0, "\n");
        String formatted = formatter.format(createInvoice());

        String expected = "Seller: Xyz Inc.\n" +
            "Buyer: Abc Inc.\n" +
            "Details:(line,product,price,quantity,amount)\n" +
            "1. Product1 $2. 1. $2.\n" +
            "2. Product2 $10. 0. $1.\n" +
            "Total: $3.\n";
        assertEquals(expected, formatted);
    }

    @Test
    void invoice_should_formatted_with_precision_equals_1_when_given_1() {
        InvoiceFormatter formatter = new InvoiceFormatter(1, "\n");
        String formatted = formatter.format(createInvoice());

        String expected = "Seller: Xyz Inc.\n" +
            "Buyer: Abc Inc.\n" +
            "Details:(line,product,price,quantity,amount)\n" +
            "1. Product1 $2.0 1.0 $2.0\n" +
            "2. Product2 $10.0 0.1 $1.0\n" +
            "Total: $3.0\n";
        assertEquals(expected, formatted);
    }

    @Test
    void invoice_should_formatted_with_precision_equals_2_when_given_2() {
        InvoiceFormatter formatter = new InvoiceFormatter(2, "\n");
        String formatted = formatter.format(createInvoice());

        String expected = "Seller: Xyz Inc.\n" +
            "Buyer: Abc Inc.\n" +
            "Details:(line,product,price,quantity,amount)\n" +
            "1. Product1 $2.00 1.00 $2.00\n" +
            "2. Product2 $10.00 0.10 $1.00\n" +
            "Total: $3.00\n";
        assertEquals(expected, formatted);
    }

}