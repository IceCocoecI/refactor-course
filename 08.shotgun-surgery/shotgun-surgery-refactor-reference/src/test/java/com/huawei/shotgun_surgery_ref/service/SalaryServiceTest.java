/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.service;

import com.huawei.shotgun_surgery_ref.model.Currency;
import com.huawei.shotgun_surgery_ref.model.Employee;
import com.huawei.shotgun_surgery_ref.model.Money;
import com.huawei.shotgun_surgery_ref.model.PaySlip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 薪资管理测试类
 *
 * @since 2021-11-02
 */
class SalaryServiceTest {
    private final SalaryService salaryService = new SalaryService();

    private Employee employee;

    @BeforeEach
    public void before() {
        employee = new Employee(1111, "zhangsan", new Money(10000, Currency.CNY));
    }

    @Test
    public void checkPaySlip() {
        PaySlip paySlip = new PaySlip(employee.getId(), employee.getSalary().getAmount());
        final PaySlip detail = salaryService.calculateDetailOfPaySlip(paySlip);
        Assertions.assertEquals(1111, detail.getEmployeeId());
        Assertions.assertEquals(1000, detail.getTax());
        Assertions.assertEquals(800, detail.getInsurance());
        Assertions.assertEquals(8200, detail.getActualPay());
    }

    @Test
    public void checkActualPayRaiseByUsdWhenRaise() {
        final Money payRaise = new Money(100, Currency.USD);
        salaryService.raisePay(employee, payRaise);
        Assertions.assertEquals(10680, employee.getSalary().getAmount());
    }
}