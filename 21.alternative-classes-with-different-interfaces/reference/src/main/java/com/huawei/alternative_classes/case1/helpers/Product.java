/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case1.helpers;

import java.util.Objects;

/**
 * 制造的产品
 *
 * @since 2021-11-15
 */
public class Product {
    // 商品名称
    private final String name;
    // 制造者
    private final String creator;

    public Product(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(creator, product.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creator);
    }
}
