package com.huawei.data_class;

import com.huawei.data_class.constant.Gender;
import com.huawei.data_class.data.Department;
import com.huawei.data_class.dto.Staff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @since 2021-08-11
 */
class AuditTest {
    private static final String TRUSTWORTHINESS = "Trustworthiness Enabling Dept";

    @Test
    void auditGenderRatio() {
        // 可信使能部员工
        Staff staff1 = new Staff("张三", Gender.MALE, 30, TRUSTWORTHINESS);
        Staff staff2 = new Staff("李四", Gender.FEMALE, 30, TRUSTWORTHINESS);
        Staff staff3 = new Staff("王五", Gender.FEMALE, 30, TRUSTWORTHINESS);
        Department trustworthinessDepartment = new Department();
        trustworthinessDepartment.minister = "General Gui";
        trustworthinessDepartment.setName(TRUSTWORTHINESS);
        trustworthinessDepartment.setStaffs(Arrays.asList(staff1, staff2, staff3));

        double genderRatio = new Audit().auditGenderRatio(trustworthinessDepartment);

        Assertions.assertEquals(0.5, genderRatio);
    }
}