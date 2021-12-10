/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.middle_man.employeemsg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * PersonTest
 *
 * @since 2021-07-05
 */
public class EmployeeTest {
    private static Employee employee;

    @BeforeAll
    static void init() {
        employee = new Employee();
        employee.setName("李华");
        employee.setAge(25);
        Department department = new Department();
        department.setId("001");
        department.setChargeCode("0011001");
        department.setManager("韩梅");
        department.setType("研发");
        department.setTotalEmployee("20");
        department.setFunction("dev");
        department.setLocation("第五大道");
        employee.setDepartment(department);
    }

    @Test
    void should_getName() {
        assertEquals("李华", employee.getName());
    }

    @Test
    void should_getAge() {
        assertEquals(25, employee.getAge());
    }

    @Test
    void should_getDepId() {
        assertEquals("001", employee.getDepartmentId());
    }

    @Test
    void should_getDepChargeCode() {
        assertEquals("0011001", employee.getDepartmentChargeCode());
    }

    @Test
    void should_getDepManager() {
        assertEquals("韩梅", employee.getDepartmentManager());
    }

    @Test
    void should_getDepType() {
        assertEquals("研发", employee.getDepartmentType());
    }

    @Test
    void should_getDepTotalPerson() {
        assertEquals("20", employee.getDepartmentTotalEmployee());
    }

    @Test
    void should_getDepFunction() {
        assertEquals("dev", employee.getDepartmentFunction());
    }

    @Test
    void should_getDepLocation() {
        assertEquals("第五大道", employee.getDepartmentLocation());
    }
}