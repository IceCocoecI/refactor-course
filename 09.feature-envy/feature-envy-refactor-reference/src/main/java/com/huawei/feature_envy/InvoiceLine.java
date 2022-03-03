/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.feature_envy;

import java.math.BigDecimal;

/**
 * 发票单行明细
 *
 * @version 1.0
 * @since 2021/10/30
 */
public class InvoiceLine {
    private final String product;

    private final BigDecimal quantity;

    private final BigDecimal price;

    public InvoiceLine(String product, BigDecimal quantity,
        BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    BigDecimal getAmount() {
        return getQuantity().multiply(getPrice());
    }
}
