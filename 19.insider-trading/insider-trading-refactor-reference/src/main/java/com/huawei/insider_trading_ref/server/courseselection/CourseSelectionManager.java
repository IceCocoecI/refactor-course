/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.insider_trading_ref.server.courseselection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.huawei.insider_trading_ref.server.courseselection.course.Course;
import com.huawei.insider_trading_ref.server.courseselection.course.CourseManager;
import com.huawei.insider_trading_ref.server.courseselection.student.Gender;
import com.huawei.insider_trading_ref.server.courseselection.student.Student;
import com.huawei.insider_trading_ref.server.courseselection.student.StudentManager;

/**
 * 选课系统管理
 *
 * @since 2021-11-12
 */
public class CourseSelectionManager {
    // TODO: 对于当前代码内部的两个MAP，可以进一步用Pair等方案进行优化，大家可以自行尝试，
    //  但不论用哪种方案优化，变化都被限定在了“明面上”的模块中，而不是分散在多个子模块，这也是消除内幕交易的价值之一
    private static final Map<String, List<Student>> COURSE_STUDENTS_MAP = new HashMap<>();

    private static final Map<Integer, List<Course>> STUDENT_COURSE_MAP = new HashMap<>();

    private final StudentManager studentManager = new StudentManager();

    private final CourseManager courseManager = new CourseManager();

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
     * @param studentId 学生ID
     * @param courseNames 课程名称
     */
    public void assignCourses(int studentId, List<String> courseNames) {
        if (courseNames == null || courseNames.isEmpty()) {
            return;
        }
        selectCourse(studentId, courseNames);
        courseNames.forEach(courseName -> addStudentInCourse(courseName, this.studentManager.queryStudent(studentId)));
    }

    private void selectCourse(int studentId, List<String> courseNames) {
        courseNames.stream()
            .map(this.courseManager::queryCourse)
            .filter(Objects::nonNull)
            .forEachOrdered(
                course -> STUDENT_COURSE_MAP.computeIfAbsent(studentId, k -> new ArrayList<>()).add(course));
    }

    /**
     * 查询某学生某课程的老师
     * 
     * @param studentId 学生id
     * @param courseName 课程名称
     * @return 某学生某课程的老师
     */
    public String queryStudentCourseTeacher(int studentId, String courseName) {
        Optional<Course> course =
            queryStudentSelectCourses(studentId)
                .stream()
                .filter(selectedCourse -> selectedCourse.getName().equals(courseName))
                .findFirst();
        return course.isPresent() ? course.get().getTeacher() : "no teacher info";
    }

    public void importStudents(List<Student> students) {
        studentManager.importStudents(students);
    }

    public void importCourses(List<Course> courses) {
        courseManager.importCourses(courses);
    }
}
