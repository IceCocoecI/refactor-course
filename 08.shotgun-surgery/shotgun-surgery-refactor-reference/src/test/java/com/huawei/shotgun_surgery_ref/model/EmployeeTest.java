/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 员工测试类
 *
 * @since 2021-11-02
 */
class EmployeeTest {

    @Test
    void raisePayOfCurrencyCny() {
        final Employee employee = initEmployee();
        employee.raisePay(new Money(1000, Currency.CNY));
        Assertions.assertEquals(11000, employee.getSalary().getAmount());
        Assertions.assertEquals(Currency.CNY, employee.getSalary().getCurrency());
    }

    @Test
    void raisePayOfCurrencyUsd() {
        final Employee employee = initEmployee();
        employee.raisePay(new Money(100, Currency.USD));
        Assertions.assertEquals(10680, employee.getSalary().getAmount());
        Assertions.assertEquals(Currency.CNY, employee.getSalary().getCurrency());
    }

    private Employee initEmployee() {
        return new Employee(1, "zhangsan", new Money(10000, Currency.CNY));
    }
}