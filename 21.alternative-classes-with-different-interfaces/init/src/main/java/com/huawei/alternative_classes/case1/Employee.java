/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case1;

/**
 * 雇员
 *
 * @since 2021-11-15
 */
public class Employee {
    private String identity;

    private String name;

    private boolean isMale;

    public void setValues(String name, boolean isMale) {
        this.name = name;
        this.isMale = isMale;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getIdentity() {
        return identity;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }
}
