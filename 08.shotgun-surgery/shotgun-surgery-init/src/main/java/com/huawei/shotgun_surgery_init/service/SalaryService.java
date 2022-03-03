/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.service;

import com.huawei.shotgun_surgery_init.model.Currency;
import com.huawei.shotgun_surgery_init.model.Employee;
import com.huawei.shotgun_surgery_init.model.Money;
import com.huawei.shotgun_surgery_init.model.PaySlip;

import java.text.MessageFormat;

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
        final double rate = exchangeRateToCny(increase.getCurrency()) / exchangeRateToCny(originalSalary.getCurrency());
        final double finalSalary = originalSalary.getAmount() + increase.getAmount() * rate;
        final Money resultSalary = new Money(finalSalary, originalSalary.getCurrency());
        employee.setSalary(resultSalary);

        doSomeRecord(employee);
    }

    /**
     * 转换为兑人民币汇率
     *
     * @param from 转换币种
     * @return 汇率
     */
    private double exchangeRateToCny(Currency from) {
        switch (from) {
            case CNY:
                return 1.0;
            case USD:
                return 6.8;
            case GBP:
                return 9.6;
            case BTC:
                return 60000.0;
            default:
                throw new IllegalArgumentException(MessageFormat.format("unsupported exchange {0} to CNY", from));
        }
    }

    private void doSomeRecord(Employee employee) {
        // save to database
    }
}
