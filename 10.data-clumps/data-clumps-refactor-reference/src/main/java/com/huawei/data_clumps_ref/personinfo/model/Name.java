/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_clumps_ref.personinfo.model;

import com.huawei.data_clumps_ref.personinfo.constant.Constant;

/**
 * 姓名
 *
 * @since 2021-11-05
 */
public class Name {
    private final String firstName;

    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * 打印格式的姓名
     * 
     * @return 姓名
     */
    public String printName() {
        return "First Name: " + firstName + Constant.LINE_SEPARATOR
            + "Last Name: " + lastName;
    }
}
