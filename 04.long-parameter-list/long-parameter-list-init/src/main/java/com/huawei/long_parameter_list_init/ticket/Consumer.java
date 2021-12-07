package com.huawei.long_parameter_list_init.ticket;

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
}
