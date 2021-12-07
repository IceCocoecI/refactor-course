/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.global_data_init.server.classinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班级学生信息
 *
 * @since 2021-11-04
 */
public class ClassStudentsInfo {
    /**
     * 班级、学生信息Map，key为班级名称，value为班级中的学生
     */
    private static final Map<String, Students> CLASS_STUDENTS_INFO = new HashMap<>();

    /**
     * 班级总数上限
     */
    public static int classNumUpLimit = 3;

    public List<String> getStudents(String className) {
        return CLASS_STUDENTS_INFO.containsKey(className)
            ? CLASS_STUDENTS_INFO.get(className).getStudentNames()
            : new ArrayList<>();
    }

    public void addStudents(String className, List<String> studentNames) {
        if (!CLASS_STUDENTS_INFO.containsKey(className)) {
            throw new IllegalArgumentException("class not exist");
        }

        CLASS_STUDENTS_INFO.get(className).addStudents(studentNames);
    }

    public void addOneClass(String className) {
        if (CLASS_STUDENTS_INFO.containsKey(className)) {
            throw new IllegalArgumentException("class already exist");
        }

        if (CLASS_STUDENTS_INFO.size() >= classNumUpLimit) {
            throw new IllegalArgumentException("the number of classes has reached upLimit");
        }

        CLASS_STUDENTS_INFO.put(className, new Students(new ArrayList<>()));
    }
}
