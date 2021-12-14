package com.huawei.data_class;

import com.huawei.data_class.constant.Gender;
import com.huawei.data_class.data.Department;

import java.util.List;

/**
 * hrbp管理
 *
 * @since 2021-07-17
 */
public class Hrbp {
    private final List<Department> departments; // 部门列表

    public Hrbp(List<Department> departments) {
        this.departments = departments;
    }

    /**
     * 统计所有部门下(男/女)性别员工数量
     *
     * @return (男/女)性别员工总数
     */
    public long getStaffNumOfGender(Gender gender) {
        long sum = 0L;
        for (Department department : departments) {
            long genderStaffNums = department.getStaffs().stream()
                .filter(staff -> staff.getGender().equals(gender))
                .count();
            sum += genderStaffNums;
        }
        return sum;
    }
}
