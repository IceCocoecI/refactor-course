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
 * WorkerTest测试类
 *
 * @since 2021-11-15
 */
class WorkerTest {
    @Test
    void setProperties_should_work() {
        Worker worker = new Worker().setProperties(Sex.MALE, "Andy", "112");
        assertEquals(Sex.MALE, worker.getSex());
        assertEquals("Andy", worker.getName());
        assertEquals("112", worker.getId());
    }

    @Test
    void function_should_work() {
        Worker worker = new Worker().setProperties(Sex.MALE, "Andy", "112");
        Product result = worker.produce(new Material("abc"));
        assertEquals(new Product("cba", "112"), result);
    }

    @Test
    void sex_property_should_work() {
        Worker worker = new Worker().setProperties(Sex.MALE, "Andy", "112");

        worker.setSex(Sex.MALE);
        assertEquals(Sex.MALE, worker.getSex());
        worker.setSex(Sex.FEMALE);
        assertEquals(Sex.FEMALE, worker.getSex());
    }

}