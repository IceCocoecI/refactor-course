/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.model;

import java.util.Arrays;
import java.util.List;

/**
 * 币种
 *
 * @since 2021-11-02
 */
public enum Currency {
    CNY,
    USD,
    GBP,
    BTC;

    private final static List<Currency> SUPPORTED_CURRENCY = Arrays.asList(CNY, USD, GBP);

    /**
     * 校验是否支持输入的币种
     *
     */
    public boolean isSupported() {
        return SUPPORTED_CURRENCY.contains(this);
    }
}
