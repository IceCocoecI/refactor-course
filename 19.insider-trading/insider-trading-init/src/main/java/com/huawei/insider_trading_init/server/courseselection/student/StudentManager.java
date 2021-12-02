/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.server.courseselection.student;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生管理类
 *
 * @since 2021-11-05
 */
public class StudentManager {
    private static final List<Student> STUDENTS = new ArrayList<>();

    /**
     * 批量导入学生信息
     *
     * @param students 学生
     */
    public void importStudents(List<Student> students) {
        students.stream()
            .filter(student -> STUDENTS.stream().noneMatch(s -> s.getId() == student.getId()))
            .forEachOrdered(STUDENTS::add);
    }

    /**
     * 学生信息查询
     * 
     * @param studentId 学生ID
     * @return 学生信息
     */
    public Student queryStudent(int studentId) {
        return STUDENTS.stream()
            .filter(student -> student.getId() == studentId)
            .findFirst()
            .orElse(null);
    }

}
