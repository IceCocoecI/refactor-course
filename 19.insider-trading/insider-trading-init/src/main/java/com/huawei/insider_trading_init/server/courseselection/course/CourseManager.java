/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.server.courseselection.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.huawei.insider_trading_init.server.courseselection.student.StudentManager;

/**
 * 课程管理
 *
 * @since 2021-11-05
 */
public class CourseManager {
    private static final List<Course> COURSES = new ArrayList<>();

    private static final Map<Integer, List<Course>> STUDENT_COURSE_MAP = new HashMap<>();

    /**
     * 查询某学生选择的课程
     *
     * @param studentId 学生ID
     * @return 选择的课程
     */
    public static List<Course> queryStudentSelectCourses(int studentId) {
        return STUDENT_COURSE_MAP.getOrDefault(studentId, new ArrayList<>());
    }

    /**
     * 学生选课
     *
     * @param studentManager
     * @param courseManager 课程信息管理
     * @param studentId 学生ID
     * @param courseNames 课程名称
     */
    public static void assignCourses(StudentManager studentManager, CourseManager courseManager, int studentId, List<String> courseNames) {
        if (courseNames == null || courseNames.isEmpty()) {
            return;
        }
        selectCourse(courseManager, studentId, courseNames);
        courseNames.forEach(courseName -> StudentManager.addStudentInCourse(courseName, studentManager.queryStudent(studentId)));
    }

    private static void selectCourse(CourseManager courseManager, int studentId, List<String> courseNames) {
        courseNames.stream()
            .map(courseManager::queryCourse)
            .filter(Objects::nonNull)
            .forEachOrdered(
                course -> STUDENT_COURSE_MAP.computeIfAbsent(studentId, k -> new ArrayList<>()).add(course));
    }

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
            queryStudentSelectCourses(studentId)
                .stream()
                .filter(selectedCourse -> selectedCourse.getName().equals(courseName))
                .findFirst();
        return course.isPresent() ? course.get().getTeacher() : "no teacher info";
    }

}
