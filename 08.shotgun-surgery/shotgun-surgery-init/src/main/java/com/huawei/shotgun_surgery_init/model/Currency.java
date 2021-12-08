/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.model;

import java.text.MessageFormat;
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

    private static final double RATE_CNY = 1.0;

    private static final double RATE_USD_TO_CNY = 6.8;

    private static final double RATE_GBP_TO_CNY = 9.6;

    private static final double RATE_BTC_TO_CNY = 60000.0;

    public static Map<Currency, Double> getCurrencyDoubleMap() {
        Map<Currency, Double> map = new HashMap<>();
        map.put(CNY, RATE_CNY);
        map.put(USD, RATE_USD_TO_CNY);
        map.put(GBP, RATE_GBP_TO_CNY);
        map.put(BTC, RATE_BTC_TO_CNY);
        return map;
    }

    /**
     * 校验是否支持输入的币种
     */
    public boolean isSupported() {
        return SUPPORTED_CURRENCY.contains(this);
    }

    public double exchangeRate(Currency to) {
        return exchangeRateToCny() / to.exchangeRateToCny();
    }

    /**
     * 转换为兑人民币汇率
     *
     * @return 汇率
     */
    private double exchangeRateToCny() {
        switch (this) {
            case CNY:
                return RATE_CNY;
            case USD:
                return RATE_USD_TO_CNY;
            case GBP:
                return RATE_GBP_TO_CNY;
            case BTC:
                return RATE_BTC_TO_CNY;
            default:
                throw new IllegalArgumentException(MessageFormat.format("unsupported exchange {0} to CNY", this));
        }
    }
}
