/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case2.line;

import java.math.BigDecimal;

/**
 * 产品生产线
 *
 * @since 2021-11-15
 */
public class ProductLine {
    // 商品名称
    private final String product;
    // 数量
    private final BigDecimal quantity;
    // 单价
    private final BigDecimal price;
    // 折扣
    private final BigDecimal discount;

    public ProductLine(String product, BigDecimal quantity,
                       BigDecimal price, BigDecimal discount) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
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

    public BigDecimal getDiscount() {
        return discount;
    }

    // 总额
    public BigDecimal getAmount() {
        return getQuantity().multiply(getPrice()).multiply(getDiscount());
    }
}
