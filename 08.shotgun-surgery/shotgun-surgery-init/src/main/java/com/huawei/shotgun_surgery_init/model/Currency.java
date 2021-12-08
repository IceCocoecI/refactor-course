/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<Currency, Double> getCurrencyDoubleMap() {
        Map<Currency, Double> map = new HashMap<>();
        map.put(CNY, 1.0);
        map.put(USD, 6.8);
        map.put(GBP, 9.6);
        map.put(BTC, 60000.0);
        return map;
    }

    /**
     * 校验是否支持输入的币种
     *
     */
    public boolean isSupported() {
        return SUPPORTED_CURRENCY.contains(this);
    }
}
