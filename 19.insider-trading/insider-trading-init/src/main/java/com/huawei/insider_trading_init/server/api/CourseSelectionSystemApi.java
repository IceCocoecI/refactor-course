/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_init.server.api;

import java.util.List;

import com.huawei.insider_trading_init.server.courseselection.CourseSelectionManager;
import com.huawei.insider_trading_init.server.courseselection.course.Course;
import com.huawei.insider_trading_init.server.courseselection.student.Gender;
import com.huawei.insider_trading_init.server.courseselection.student.Student;

/**
 * 选课管理系统对外api
 *
 * @since 2021-11-11
 */
public class CourseSelectionSystemApi {
    private final CourseSelectionManager courseSelectionManager = new CourseSelectionManager();

    /**
     * 批量导入学生信息
     * 
     * @param students 学生
     */
    public void importStudents(List<Student> students) {
        courseSelectionManager.getStudentManager().importStudents(students);
    }

    /**
     * 批量导入课程信息
     * 
     * @param courses 课程信息
     */
    public void importCourses(List<Course> courses) {
        courseSelectionManager.getCourseManager().importCourses(courses);
    }

    /**
     * 学生选课
     * 
     * @param studentId 学生ID
     * @param courseNames 课程名称
     */
    public void assignCourses(int studentId, List<String> courseNames) {
        CourseSelectionManager.assignCourses(courseSelectionManager.getStudentManager(), courseSelectionManager.getCourseManager(), studentId, courseNames);
    }

    /**
     * 查询学生所选课程
     * 
     * @param studentId 学生ID
     * @return 学生所选课程
     */
    public List<Course> queryStudentSelectCourses(int studentId) {
        return CourseSelectionManager.queryStudentSelectCourses(studentId);
    }

    /**
     * 查询某学生某门课程的老师
     * 
     * @param studentId 学生ID
     * @param courseName 课程名称
     * @return 老师名
     */
    public String queryStudentCourseTeacher(int studentId, String courseName) {
        return CourseSelectionManager.queryStudentCourseTeacher(courseSelectionManager.getStudentManager(), studentId, courseName);
    }

    /**
     * 统计指定课程某性别学生数量
     * 
     * @param courseName 课程名称
     * @param gender 性别
     * @return 学生数目
     */
    public long statisticStudentByGender(String courseName, Gender gender) {
        return CourseSelectionManager.statisticStudentByGender(courseName, gender);
    }
}
