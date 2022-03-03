/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_ref.server.api;

import static com.huawei.insider_trading_ref.server.courseselection.student.Gender.BOY;
import static com.huawei.insider_trading_ref.server.courseselection.student.Gender.GIRL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.huawei.insider_trading_ref.server.courseselection.course.Course;
import com.huawei.insider_trading_ref.server.courseselection.student.Student;

/**
 * CourseSelectionSystemApi测试
 *
 * @since 2021-11-05
 */
class CourseSelectionSystemApiTest {
    private static final CourseSelectionSystemApi COURSE_SELECTION_SYSTEM_API = new CourseSelectionSystemApi();

    @BeforeAll
    static void init() {
        initCourses();
        initStudents();
        // 模拟学生选课
        simulationSelectCourse();
    }

    @Test
    public void queryCourse_and_statistic_student() {
        // 查询某个学生某课程的老师
        final String teacher = COURSE_SELECTION_SYSTEM_API.queryStudentCourseTeacher(1, "history");
        // 统计课程的数据
        final long literatureGirlCount = COURSE_SELECTION_SYSTEM_API.statisticStudentByGender("literature", GIRL);

        assertEquals("teacher1", teacher);
        assertEquals(2, literatureGirlCount);
    }

    @Test
    public void should_get_student_select_courses() {
        final List<Course> courses = COURSE_SELECTION_SYSTEM_API.queryStudentSelectCourses(1);

        assertEquals(2, courses.size());
        assertEquals("history", courses.get(0).getName());
        assertEquals("literature", courses.get(1).getName());
    }

    private static void simulationSelectCourse() {
        COURSE_SELECTION_SYSTEM_API.assignCourses(1, Arrays.asList("history", "literature"));
        COURSE_SELECTION_SYSTEM_API.assignCourses(2, Arrays.asList("history", "literature"));
        COURSE_SELECTION_SYSTEM_API.assignCourses(3, Arrays.asList("literature", "music"));
        COURSE_SELECTION_SYSTEM_API.assignCourses(4, Arrays.asList("literature", "music"));
    }

    private static void initCourses() {
        COURSE_SELECTION_SYSTEM_API
            .importCourses(Arrays.asList(
                new Course("history", "teacher1"),
                new Course("literature", "teacher2"),
                new Course("music", "teacher3")));
    }

    private static void initStudents() {
        COURSE_SELECTION_SYSTEM_API.importStudents(Arrays.asList(
            new Student(1, "zhangsan", BOY),
            new Student(2, "lisi", BOY),
            new Student(3, "lisi", GIRL),
            new Student(4, "wangwu", GIRL)));
    }
}