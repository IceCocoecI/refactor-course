/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.comments;

/**
 * 待支付信息
 *
 * @since 2021-09-06
 */
public class Owing {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 获取待支付信息
     * 
     * @param name 物品名称
     * @return 待支付信息
     */
    public String getOwingInfo(String name) {
        someProcess();
        return createDetails(name);
    }

    private String createDetails(String name) {
        return "name: " + name + LINE_SEPARATOR
            + "amount: " + getAmount() + LINE_SEPARATOR
            + "someOwingInfo: " + getSomeOwingInfo();
    }

    private String getSomeOwingInfo() {
        return "someOwingInfo";
    }

    private int getAmount() {
        return 10;
    }

    private void someProcess() {
    }
}
