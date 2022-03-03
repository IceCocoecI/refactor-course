/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case1;

import com.huawei.alternative_classes.case1.helpers.Material;
import com.huawei.alternative_classes.case1.helpers.Product;
import com.huawei.alternative_classes.case1.helpers.Sex;

/**
 * 工人
 *
 * @since 2021-11-15
 */
public class Worker {
    private String id;

    private String name;

    private Sex sex;

    public Worker setProperties(Sex sex, String name, String id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Worker setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public Product produce(Material material) {
        return new Product(new StringBuilder(material.getName()).reverse().toString(), id);
    }
}
