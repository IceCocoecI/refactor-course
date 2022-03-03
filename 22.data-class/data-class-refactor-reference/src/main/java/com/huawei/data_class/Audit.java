package com.huawei.data_class;

import com.huawei.data_class.constant.Gender;
import com.huawei.data_class.data.Department;

/**
 * 审计部门审计
 *
 * @since 2021-07-17
 */
public class Audit {
    /**
     * 审计男女比率
     *
     * @param department 部门信息
     * @return 男女比例
     */
    public double auditGenderRatio(Department department) {
        long maleNums = department.getStaffNumOfGender(Gender.MALE);
        long femaleNums = department.getStaffNumOfGender(Gender.FEMALE);

        // 女员工数为0时 返回-1
        if (femaleNums == 0) {
            return -1.0;
        }
        return maleNums / (femaleNums * 1.0);
    }
}
