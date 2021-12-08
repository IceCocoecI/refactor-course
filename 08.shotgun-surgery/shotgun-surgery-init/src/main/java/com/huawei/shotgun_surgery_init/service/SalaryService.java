/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.service;

import com.huawei.shotgun_surgery_init.model.Currency;
import com.huawei.shotgun_surgery_init.model.Employee;
import com.huawei.shotgun_surgery_init.model.Money;
import com.huawei.shotgun_surgery_init.model.PaySlip;

/**
 * 薪资管理
 *
 * @since 2021-11-02
 */
public class SalaryService {
    /**
     * 计算工资单详情
     *
     * @param paySlip 工资单
     * @return 工资单
     */
    public PaySlip calculateDetailOfPaySlip(PaySlip paySlip) {
        paySlip.calculateTaxForPaySlip();
        paySlip.calculateInsuranceForPaySlip();
        paySlip.calculateActualPayForPaySlip();
        return paySlip;
    }

    /**
     * 员工涨薪
     *
     * @param employee 员工
     * @param increase 涨薪幅度
     */
    public void raisePay(Employee employee, Money increase) {
        if (employee.getSalary().getAmount() > 30000) {
            throw new IllegalArgumentException("salary is too high, not support");
        }
        if (increase.getAmount() > 5000) {
            throw new IllegalArgumentException("money is beyond max range");
        }

        final Money originalSalary = employee.getSalary();
        final double rate = increase.getCurrency().exchangeRate(Currency.CNY) / originalSalary.getCurrency().exchangeRate(Currency.CNY);
        final double finalSalary = originalSalary.getAmount() + increase.getAmount() * rate;
        final Money resultSalary = new Money(finalSalary, originalSalary.getCurrency());
        employee.setSalary(resultSalary);

        doSomeRecord(employee);
    }

    private void doSomeRecord(Employee employee) {
        // save to database
    }
}
