package com.huawei.long_parameter_list_init.ticket.consumer;

import com.huawei.long_parameter_list_init.ticket.constant.Constant;

public class Consumer {
    private final String name;
    private final int age;
    private final boolean isChild;
    private final boolean isStudent;

    /**
     * @param name 姓名
     * @param age 年龄
     * @param isChild 是否儿童
     * @param isStudent 是否学生
     */
    public Consumer(String name, int age, boolean isChild, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isChild = isChild;
        this.isStudent = isStudent;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isChild() {
        return isChild;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public String getConsumerInfo() {
        return "consumerInfo" + Constant.LINE_SEPARATOR
            + "\tname: " + name + Constant.LINE_SEPARATOR
            + "\tage: " + age + Constant.LINE_SEPARATOR
            + "\tisStudent: " + isStudent + Constant.LINE_SEPARATOR
            + "\tisChild: " + isChild + Constant.LINE_SEPARATOR;
    }
}
