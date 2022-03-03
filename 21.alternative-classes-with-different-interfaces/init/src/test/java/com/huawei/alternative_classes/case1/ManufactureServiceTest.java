/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.huawei.alternative_classes.case1.helpers.Material;
import com.huawei.alternative_classes.case1.helpers.Product;
import com.huawei.alternative_classes.case1.helpers.Sex;

/**
 * ManufactureService测试类
 *
 * @since 2021-11-15
 */
class ManufactureServiceTest {
    @Test
    void produceUsingWorker() {
        ManufactureService manufactureService = new ManufactureService("Andy", "112", Sex.MALE);
        Product product = manufactureService.produceUsingWorker(new Material("abc"));

        assertEquals(new Product("cba", "112"), product);
    }

    @Test
    void produceUsingEmployee() {
        ManufactureService manufactureService = new ManufactureService("Andy", "112", Sex.MALE);
        Product product = manufactureService.produceUsingEmployee(new Material("abc"));

        assertEquals(new Product("cba", "112"), product);
    }
}