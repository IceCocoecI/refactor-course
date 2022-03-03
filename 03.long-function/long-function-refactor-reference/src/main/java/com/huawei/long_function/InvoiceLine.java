/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.long_function;

/**
 * @version 1.0
 * @description
 * @since 2021/9/6
 */
public class InvoiceLine {
    private final String product;
    private final float quantity;
    private final float price;

    public InvoiceLine(String product, int quantity, int price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    boolean isValid() {
        return product == null || "".equals(product.trim())
                || price <= 0 || quantity <= 0;
    }

    public float getAmount() {
        return price * quantity;
    }

    public String getProduct() {
        return product;
    }

    public float getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }
}
