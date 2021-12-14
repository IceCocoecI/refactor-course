package com.huawei.data_class.data;

import com.huawei.data_class.constant.Gender;
import com.huawei.data_class.dto.Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 部门信息
 *
 * @since 2021-07-15
 */
public class Department {
    private final String minister; // 部长

    private final String name; // 部门名称

    private final List<Staff> staffs = new ArrayList<>(); // 部门员工列表

    public Department(String minister, String name) {
        this.minister = minister;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Staff> getStaffs() {
        return Collections.unmodifiableList(staffs);
    }

    public void addStaffs(List<Staff> staffs) {
        this.staffs.addAll(staffs);
    }

    public void deleteStaffs(List<Staff> staffs) {
        this.staffs.removeAll(staffs);
    }

    public String getMinister() {
        return minister;
    }

    public long getStaffNumOfGender(Gender male) {
        return getStaffs().stream()
            .filter(staff -> male.equals(staff.getGender()))
            .count();
    }
}
