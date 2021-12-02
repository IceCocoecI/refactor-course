/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.server.courseselection.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生管理类
 *
 * @since 2021-11-05
 */
public class StudentManager {
    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final Map<String, List<Student>> COURSE_STUDENTS_MAP = new HashMap<>();

    /**
     * 为某课程增加一位学生
     *
     * @param courseName 课程名称
     * @param student 学生
     */
    public static void addStudentInCourse(String courseName, Student student) {
        COURSE_STUDENTS_MAP.computeIfAbsent(courseName, k -> new ArrayList<>()).add(student);
    }

    /**
     * 统计指定课程某性别学生数量
     *
     * @param courseName 课程名称
     * @param gender 性别
     * @return 学生数目
     */
    public static long statisticStudentByGender(String courseName, Gender gender) {
        return COURSE_STUDENTS_MAP.getOrDefault(courseName, new ArrayList<>())
            .stream()
            .filter(student -> student.getGender().equals(gender))
            .count();
    }

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
