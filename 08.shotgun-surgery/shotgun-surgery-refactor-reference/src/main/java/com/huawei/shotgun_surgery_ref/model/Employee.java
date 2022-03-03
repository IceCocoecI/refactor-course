/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.model;

/**
 * 员工
 *
 * @since 2021-11-02
 */
public class Employee {
    private final int id;

    private final String name;

    private Money salary;

    public Employee(int id, String name, Money salary) {
        this(id, name);
        this.salary = salary;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getSalary() {
        return salary;
    }

    public void setSalary(Money salary) {
        this.salary = salary;
    }

    /**
     * 员工涨薪
     *
     * @param increase 涨薪幅度
     */
    public void raisePay(Money increase) {
        this.salary = salary.add(increase);
    }
}
