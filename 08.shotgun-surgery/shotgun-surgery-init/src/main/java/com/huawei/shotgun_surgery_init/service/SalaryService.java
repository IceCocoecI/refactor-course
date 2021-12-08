/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.service;

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
        doSomeCheck(employee, increase);

        raise(employee, increase);

        doSomeRecord(employee);
    }

    private void raise(Employee employee, Money increase) {
        final Money originalSalary = employee.getSalary();
        final Money resultSalary = originalSalary.add(increase);
        employee.setSalary(resultSalary);
    }

    private void doSomeCheck(Employee employee, Money increase) {
        if (employee.getSalary().getAmount() > 30000) {
            throw new IllegalArgumentException("salary is too high, not support");
        }
        if (increase.getAmount() > 5000) {
            throw new IllegalArgumentException("money is beyond max range");
        }
    }

    private void doSomeRecord(Employee employee) {
        // save to database
    }
}
