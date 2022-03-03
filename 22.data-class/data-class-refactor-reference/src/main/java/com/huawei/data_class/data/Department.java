package com.huawei.data_class.data;

import com.huawei.data_class.constant.Gender;
import com.huawei.data_class.dto.Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 部门信息
 *
 * @since 2021-07-16
 */
public class Department {
    private final String minister; // 部长

    private final String name; // 部门名称

    private final List<Staff> staffs = new ArrayList<>();  // 部门员工列表

    public Department(String name, String minister) {
        this.name = name;
        this.minister = minister;
    }

    /**
     * 获取部门男/女员工数
     *
     * @param gender 性别
     * @return gender 对应的员工总数
     */
    public long getStaffNumOfGender(Gender gender) {
        return staffs.stream()
            .filter(staff -> staff.getGender().equals(gender))
            .count();
    }

    public String getName() {
        return name;
    }

    public String getMinister() {
        return minister;
    }

    /**
     * 部门增加新成员
     *
     * @param staff 员工信息
     */
    public void addStaff(Staff staff) {
        staffs.add(staff);
    }

    /**
     * 批量添加新成员
     *
     * @param staffs 员工信息
     */
    public void addStaff(List<Staff> staffs) {
        this.staffs.addAll(staffs);
    }

    /**
     * 删除员工
     *
     * @param staff 员工信息
     */
    public void deleteStaff(Staff staff) {
        staffs.remove(staff);
    }

    public List<Staff> getStaffs() {
        return Collections.unmodifiableList(staffs);
    }
}
