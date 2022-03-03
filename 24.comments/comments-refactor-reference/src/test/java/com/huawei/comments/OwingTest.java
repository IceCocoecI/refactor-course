/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.comments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 待支付信息测试类
 *
 * @since 2021-09-06
 */
public class OwingTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void should_get_owingInfo() {
        Owing owing = new Owing();

        String owingInfo = owing.getOwingInfo("xxx");

        String expected = "name: xxx" + LINE_SEPARATOR
            + "amount: 10" + LINE_SEPARATOR
            + "someOwingInfo: someOwingInfo";
        assertEquals(expected, owingInfo);
    }
}