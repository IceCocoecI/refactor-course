package com.huawei.data_class;

import com.huawei.data_class.constant.Gender;
import com.huawei.data_class.data.Department;
import com.huawei.data_class.dto.Staff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * 功能测试
 *
 * @since 2021-07-19
 */
class HrbpTest {
    private static final String TRUSTWORTHINESS = "Trustworthiness Enabling Dept";

    private static final String ARCHITECTURE = "Architecture Design Dept";

    private Hrbp hrbp;

    @BeforeEach
    void before() {
        // 可信使能部员工
        Staff staff1 = new Staff("张三", Gender.MALE, 30, TRUSTWORTHINESS);
        Staff staff2 = new Staff("李四", Gender.FEMALE, 30, TRUSTWORTHINESS);
        Staff staff3 = new Staff("王五", Gender.FEMALE, 30, TRUSTWORTHINESS);

        // 架设部员工
        Staff staff4 = new Staff("无名氏", Gender.FEMALE, 30, ARCHITECTURE);

        Department trustworthinessDepartment = new Department();
        trustworthinessDepartment.minister = "General Gui";
        trustworthinessDepartment.setName(TRUSTWORTHINESS);
        trustworthinessDepartment.setStaffs(Arrays.asList(staff1, staff2, staff3));

        Department architectureDepartment = new Department();
        architectureDepartment.minister = "General Li";
        architectureDepartment.setName(ARCHITECTURE);
        architectureDepartment.setStaffs(Collections.singletonList(staff4));

        hrbp = new Hrbp(Arrays.asList(trustworthinessDepartment, architectureDepartment));
    }

    @Test
    void testGetStaffNumOfGender() {
        long staffFemaleNums = hrbp.getStaffNumOfGender(Gender.FEMALE);
        Assertions.assertEquals(staffFemaleNums, 3);

        long staffMaleNums = hrbp.getStaffNumOfGender(Gender.MALE);
        Assertions.assertEquals(staffMaleNums, 1);
    }
}