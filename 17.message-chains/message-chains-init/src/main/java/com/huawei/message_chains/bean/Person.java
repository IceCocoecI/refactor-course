/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.message_chains.bean;

/**
 * 一个员工个人信息， 包含部门{@link Department}信息。
 *
 * @since 2021-11-11
 */
public class Person {
    /** 部门信息 */
    private Department department;

    public Person(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}