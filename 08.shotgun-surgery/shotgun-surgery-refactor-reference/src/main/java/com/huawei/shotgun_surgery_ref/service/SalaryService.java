/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.service;

import com.huawei.shotgun_surgery_ref.model.Employee;
import com.huawei.shotgun_surgery_ref.model.Money;
import com.huawei.shotgun_surgery_ref.model.PaySlip;

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
        return paySlip.enrichPaySlip();
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

    private void doSomeCheck(Employee employee, Money money) {
        if (employee.getSalary().getAmount() > 30000) {
            throw new IllegalArgumentException("salary is too high, not support");
        }
        if (money.getAmount() > 5000) {
            throw new IllegalArgumentException("money is beyond max range");
        }
    }

    private void raise(Employee employee, Money increase) {
        final Money originalSalary = employee.getSalary();
        final Money resultSalary = originalSalary.add(increase);
        employee.setSalary(resultSalary);
    }

    private void doSomeRecord(Employee employee) {
        // do some record
        // save to database
    }
}
