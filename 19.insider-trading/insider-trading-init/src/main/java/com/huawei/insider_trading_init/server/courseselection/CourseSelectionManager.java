/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.server.courseselection;

import com.huawei.insider_trading_init.server.courseselection.course.CourseManager;
import com.huawei.insider_trading_init.server.courseselection.student.StudentManager;

/**
 * 选课系统管理
 *
 * @since 2021-11-12
 */
public class CourseSelectionManager {
    private final StudentManager studentManager = new StudentManager();

    private final CourseManager courseManager = new CourseManager();

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
