/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.server.courseselection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huawei.insider_trading_init.server.courseselection.course.CourseManager;
import com.huawei.insider_trading_init.server.courseselection.student.Gender;
import com.huawei.insider_trading_init.server.courseselection.student.Student;
import com.huawei.insider_trading_init.server.courseselection.student.StudentManager;

/**
 * 选课系统管理
 *
 * @since 2021-11-12
 */
public class CourseSelectionManager {
    private static final Map<String, List<Student>> COURSE_STUDENTS_MAP = new HashMap<>();
    private final StudentManager studentManager = new StudentManager();

    private final CourseManager courseManager = new CourseManager();

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
     * 学生信息管理
     */
    public StudentManager getStudentManager() {
        return studentManager;
    }

    /**
     * 课程信息管理
     */
    public CourseManager getCourseManager() {
        return courseManager;
    }
}
