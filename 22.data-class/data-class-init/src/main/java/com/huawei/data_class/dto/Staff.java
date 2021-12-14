/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_class.dto;

import com.huawei.data_class.constant.Gender;

/**
 * DTO对象，员工信息定义
 *
 * @since 2021-07-15
 */
public class Staff {
    private final String name; // 员工姓名

    private final Gender gender; // 员工性别

    private final int age; // 员工年龄

    private final String departmentName; // 员工所在部门

    public Staff(String name, Gender gender, int age, String departmentName) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
