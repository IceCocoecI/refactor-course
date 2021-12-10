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

    /**
     * 获取部门ID
     *
     * @return String
     */
    public String getDepartmentId() {
        return department.getId();
    }

    /**
     * 获取部门交易编号
     *
     * @return String
     */
    public String getDepartmentChargeCode() {
        return department.getChargeCode();
    }

    /**
     * 获取部门领导信息
     * 
     * @return String
     */
    public String getDepartmentManager() {
        return department.getManager();
    }

    /**
     * 获取部门类型
     *
     * @return String
     */
    public String getDepartmentType() {
        return department.getType();
    }

    /**
     * 获取部门人数
     * 
     * @return String
     */
    public String getDepartmentTotalEmployee() {
        return department.getTotalEmployee();
    }

    /**
     * 获取部门职能信息
     *
     * @return String
     */
    public String getDepartmentFunction() {
        return department.getFunction();
    }

    /**
     * 获取部门位置
     *
     * @return String
     */
    public String getDepartmentLocation() {
        return department.getLocation();
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
}
