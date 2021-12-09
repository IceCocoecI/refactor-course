/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.speculative_generality_ref.model;

/**
 * 性别
 *
 * @since 2021-10-19
 */
public enum Gender {
    FEMALE(0),
    MALE(1);

    private final int code;

    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
