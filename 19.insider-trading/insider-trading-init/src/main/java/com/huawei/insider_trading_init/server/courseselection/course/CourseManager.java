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

import com.huawei.insider_trading_init.server.courseselection.CourseSelectionManager;
import com.huawei.insider_trading_init.server.courseselection.student.StudentManager;

/**
 * 课程管理
 *
 * @since 2021-11-05
 */
public class CourseManager {
    private static final List<Course> COURSES = new ArrayList<>();

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
}
