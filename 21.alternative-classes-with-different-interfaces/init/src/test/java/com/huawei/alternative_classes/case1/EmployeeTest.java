/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Employee测试类
 *
 * @since 2021-11-15
 */
class EmployeeTest {
    @Test
    void setValues_should_work(){
        Employee employee = new Employee();
        employee.setValues("Andy", true);
        employee.setIdentity("112");

        assertEquals(true, employee.isMale());
        assertEquals("Andy", employee.getName());
        assertEquals("112", employee.getIdentity());
    }

    @Test
    void set_sex_should_work(){
        Employee employee = new Employee();

        employee.setMale(true);
        assertEquals(true, employee.isMale());
        employee.setMale(false);
        assertEquals(false, employee.isMale());
    }

}