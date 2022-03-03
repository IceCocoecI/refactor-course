/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.feature_envy;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 发票格式化
 *
 * @version 1.0
 * @since 2021/10/30
 */
public class InvoiceFormatter {
    /**
     * 数值格式化
     */
    private final DecimalFormat decimalFormat;

    private final String lineSeparator;

    /**
     * @param precision 格式化精度，即小数点后位数（大于等于0）
     * @param lineSeparator 换行符
     */
    public InvoiceFormatter(int precision, String lineSeparator) {
        if (precision < 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder pattern = new StringBuilder("0.");
        for (int p = 0; p < precision; p++) {
            pattern.append("0");
        }

        this.decimalFormat = new DecimalFormat(pattern.toString());
        this.lineSeparator = lineSeparator;
    }

    /**
     * 格式化发票信息
     * 
     * @param invoice 发票
     * @return 格式化结果
     */
    public final String format(Invoice invoice) {
        StringBuilder stringBuilder = new StringBuilder();

        // header:
        stringBuilder.append("Seller: ")
            .append(invoice.getSeller())
            .append(lineSeparator)
            .append("Buyer: ")
            .append(invoice.getBuyer())
            .append(lineSeparator);

        // body:
        stringBuilder.append("Details:(line,product,price,quantity,amount)").append(lineSeparator);
        int lineIndex = 1;
        for (InvoiceLine line : invoice.getLines()) {
            stringBuilder.append(lineIndex++)
                .append(". ")
                .append(line.getProduct())
                .append(" ")
                .append("$")
                .append(decimalFormat.format(line.getPrice()))
                .append(" ")
                .append(decimalFormat.format(line.getQuantity()))
                .append(" ")
                .append("$")
                .append(decimalFormat.format(line.getQuantity().multiply(line.getPrice())))
                .append(lineSeparator);
        }

        // footer
        BigDecimal total = BigDecimal.ZERO;
        for (InvoiceLine line : invoice.getLines()) {
            BigDecimal lineTotal = line.getQuantity().multiply(line.getPrice());
            total = total.add(lineTotal);
        }
        stringBuilder.append("Total: $").append(decimalFormat.format(total)).append(lineSeparator);

        return stringBuilder.toString();
    }
}
