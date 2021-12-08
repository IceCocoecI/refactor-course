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
        return enrichPaySlip(paySlip);
    }

    private PaySlip enrichPaySlip(PaySlip paySlip) {
        final double base = paySlip.getBasePay();
        final double tax = Math.max(0, (base - 5000) * 0.2);
        paySlip.setTax(tax);
        final double base1 = paySlip.getBasePay();
        final double insurance = base1 * 0.08;
        paySlip.setInsurance(insurance);
        final double base2 = paySlip.getBasePay();
        final double tax1 = Math.max(0, (base2 - 5000) * 0.2);
        final double insurance1 = base2 * 0.08;
        double actualPay = base2 - tax1 - insurance1;
        paySlip.setActualPay(actualPay);
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
