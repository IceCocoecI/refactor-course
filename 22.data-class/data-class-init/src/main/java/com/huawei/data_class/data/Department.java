package com.huawei.data_class.data;

import com.huawei.data_class.dto.Staff;

import java.util.List;

/**
 * 部门信息
 *
 * @since 2021-07-15
 */
public class Department {
    public String minister; // 部长

    private String name; // 部门名称

    private List<Staff> staffs; // 部门员工列表

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
