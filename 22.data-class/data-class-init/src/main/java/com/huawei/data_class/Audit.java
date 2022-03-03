package com.huawei.data_class;

import com.huawei.data_class.constant.Gender;
import com.huawei.data_class.data.Department;

/**
 * 审计部门审计
 *
 * 男女比例与Hrbp里面计算存在重复代码，如果统计规则变化则需要同时修改两处
 *
 * demo中代码中没有考虑空指针相关等异常，实际项目请充分考虑异常场景处理
 *
 * @since 2021-07-17
 */
public class Audit {
    /**
     * 审计男女比率
     *
     * @param department 部门信息
     * @return 男女比例 (没有女员工返回-1.0)
     */
    public double auditGenderRatio(Department department) {
        long maleNums = department.getStaffs().stream()
            .filter(staff -> Gender.MALE.equals(staff.getGender()))
            .count();
        long femaleNums = department.getStaffs().stream()
            .filter(staff ->  Gender.FEMALE.equals(staff.getGender()))
            .count();

        // 女员工数为0时 返回-1
        if (femaleNums == 0) {
            return -1.0;
        }
        return maleNums / (femaleNums * 1.0);
    }
}
