/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.server.courseselection.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.huawei.insider_trading_init.server.courseselection.student.Gender;
import com.huawei.insider_trading_init.server.courseselection.student.Student;
import com.huawei.insider_trading_init.server.courseselection.student.StudentManager;

/**
 * 课程管理
 *
 * @since 2021-11-05
 */
public class CourseManager {
    private static final List<Course> COURSES = new ArrayList<>();

    private static final Map<String, List<Student>> COURSE_STUDENTS_MAP = new HashMap<>();

    /**
     * 批量导入课程
     * 
     * @param courses 课程名称
     */
    public void importCourses(List<Course> courses) {
        courses.stream()
            .filter(course -> COURSES.stream().noneMatch(c -> c.getName().equals(course.getName())))
            .forEachOrdered(COURSES::add);
    }

    /**
     * 查询课程信息
     * 
     * @param courseName 课程名称
     * @return 课程信息
     */
    public Course queryCourse(String courseName) {
        return COURSES.stream()
            .filter(course -> course.getName().equals(courseName))
            .findFirst()
            .orElse(null);
    }

    /**
     * 查询某学生某课程的老师
     * 
     * @param studentManager 学生信息管理
     * @param studentId 学生id
     * @param courseName 课程名称
     * @return 某学生某课程的老师
     */
    public static String queryStudentCourseTeacher(StudentManager studentManager, int studentId, String courseName) {
        Optional<Course> course =
            StudentManager
                .queryStudentSelectCourses(studentId)
                .stream()
                .filter(selectedCourse -> selectedCourse.getName().equals(courseName))
                .findFirst();
        return course.isPresent() ? course.get().getTeacher() : "no teacher info";
    }

    /**
     * 为某课程增加一位学生
     * 
     * @param courseName 课程名称
     * @param student 学生
     */
    public void addStudentInCourse(String courseName, Student student) {
        COURSE_STUDENTS_MAP.computeIfAbsent(courseName, k -> new ArrayList<>()).add(student);
    }

    /**
     * 统计指定课程某性别学生数量
     *
     * @param courseName 课程名称
     * @param gender 性别
     * @return 学生数目
     */
    public long statisticStudentByGender(String courseName, Gender gender) {
        return COURSE_STUDENTS_MAP.getOrDefault(courseName, new ArrayList<>())
            .stream()
            .filter(student -> student.getGender().equals(gender))
            .count();
    }
}
