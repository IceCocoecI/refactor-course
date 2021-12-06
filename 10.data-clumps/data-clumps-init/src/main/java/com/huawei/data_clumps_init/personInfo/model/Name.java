
package com.huawei.data_clumps_init.personInfo.model;

import com.huawei.data_clumps_init.personInfo.constant.Constant;

public class Name {
    private final String firstName;

    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String printName() {
        return "First Name: " + firstName + Constant.LINE_SEPARATOR
            + "Last Name: " + lastName;
    }
}
