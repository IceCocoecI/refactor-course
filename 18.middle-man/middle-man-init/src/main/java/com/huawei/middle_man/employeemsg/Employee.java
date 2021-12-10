/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.middle_man.employeemsg;

/**
 * 员工个人信息
 *
 * @since 2021-06-17
 */
public class Employee {
    private String name;

    private int age;

    private Department department;

    /**
     * 获取人员姓名
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * 获取年龄信息
     *
     * @return int
     */
    public int getAge() {
        return age;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }
}
