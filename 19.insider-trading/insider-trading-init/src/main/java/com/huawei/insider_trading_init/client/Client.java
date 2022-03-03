/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.client;

import static com.huawei.insider_trading_init.server.courseselection.student.Gender.BOY;
import static com.huawei.insider_trading_init.server.courseselection.student.Gender.GIRL;

import java.util.Arrays;

import com.huawei.insider_trading_init.server.api.CourseSelectionSystemApi;
import com.huawei.insider_trading_init.server.courseselection.course.Course;
import com.huawei.insider_trading_init.server.courseselection.student.Student;

/**
 * 案例入口类
 *
 * @since 2021-11-05
 */
public class Client {
    private static final CourseSelectionSystemApi COURSE_SELECTION_SYSTEM_API = new CourseSelectionSystemApi();

    public static void main(String[] args) {
        initStudents();
        initCourses();

        // 完成学生选课，根据学生爱好，模拟选课
        simulationSelect();

        printStudentCourseInfo();
        printCourseStatistic();
    }

    private static void simulationSelect() {
        COURSE_SELECTION_SYSTEM_API.assignCourses(1, Arrays.asList("history", "music"));
        COURSE_SELECTION_SYSTEM_API.assignCourses(2, Arrays.asList("history", "literature"));
    }

    private static void initStudents() {
        COURSE_SELECTION_SYSTEM_API.importStudents(Arrays.asList(
            new Student(1, "zhangsan", BOY),
            new Student(2, "lisi", GIRL)));
    }

    /**
     * 初始化一些课程
     */
    private static void initCourses() {
        COURSE_SELECTION_SYSTEM_API.importCourses(Arrays.asList(
            new Course("history", "teacher1"),
            new Course("literature", "teacher2"),
            new Course("music", "teacher3")));
    }

    private static void printStudentCourseInfo() {
        // 查询1号学生的某个课程的上课老师
        String teacher = COURSE_SELECTION_SYSTEM_API.queryStudentCourseTeacher(1, "history");
        System.out.println(String.format("student 1 Monday course: %s, teacher name: %s", "history", teacher));
    }

    private static void printCourseStatistic() {
        // 统计文学课女生选择的人数
        long literatureCount = COURSE_SELECTION_SYSTEM_API.statisticStudentByGender("literature", GIRL);
        System.out.println(String.format("grils select literature : %d", literatureCount));
    }
}
