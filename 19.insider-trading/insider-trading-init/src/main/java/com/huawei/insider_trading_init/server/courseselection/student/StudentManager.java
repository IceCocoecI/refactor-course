/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.server.courseselection.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.huawei.insider_trading_init.server.courseselection.course.Course;
import com.huawei.insider_trading_init.server.courseselection.course.CourseManager;

/**
 * 学生管理类
 *
 * @since 2021-11-05
 */
public class StudentManager {
    private static final List<Student> STUDENTS = new ArrayList<>();

    private static final Map<Integer, List<Course>> STUDENT_COURSE_MAP = new HashMap<>();

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

    /**
     * 查询某学生选择的课程
     *
     * @param studentId 学生ID
     * @return 选择的课程
     */
    public List<Course> queryStudentSelectCourses(int studentId) {
        return STUDENT_COURSE_MAP.getOrDefault(studentId, new ArrayList<>());
    }

    /**
     * 学生选课
     *
     * @param courseManager 课程信息管理
     * @param studentId 学生ID
     * @param courseNames 课程名称
     */
    public void assignCourses(CourseManager courseManager, int studentId, List<String> courseNames) {
        if (courseNames == null || courseNames.isEmpty()) {
            return;
        }
        selectCourse(courseManager, studentId, courseNames);
        courseNames.forEach(courseName -> courseManager.addStudentInCourse(courseName, queryStudent(studentId)));
    }

    private void selectCourse(CourseManager courseManager, int studentId, List<String> courseNames) {
        courseNames.stream()
            .map(courseManager::queryCourse)
            .filter(Objects::nonNull)
            .forEachOrdered(
                course -> STUDENT_COURSE_MAP.computeIfAbsent(studentId, k -> new ArrayList<>()).add(course));
    }
}
