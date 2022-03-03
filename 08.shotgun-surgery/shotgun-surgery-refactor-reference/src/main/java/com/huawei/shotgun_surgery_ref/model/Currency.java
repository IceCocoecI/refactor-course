/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.model;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 货币单位
 *
 * @since 2021-11-02
 */
public enum Currency {
    CNY,
    USD,
    GBP,
    BTC;

    private static final double RATE_USD_TO_CNY = 6.8;

    private static final double RATE_GBP_TO_CNY = 9.6;

    private static final double RATE_BTC_TO_CNY = 60000;

    private static final double RATE_CNY = 1.0;

    private final static List<Currency> SUPPORTED_CURRENCY = Arrays.asList(CNY, USD, GBP);

    /**
     * 校验是否支持输入的币种
     */
    public boolean isSupported() {
        return SUPPORTED_CURRENCY.contains(this);
    }

    /**
     * 查询所有的汇率信息
     * 
     * @return 汇率信息
     */
    public static Map<Currency, Double> getAllRates() {
        Map<Currency, Double> map = new HashMap<>();
        map.put(CNY, RATE_CNY);
        map.put(USD, RATE_USD_TO_CNY);
        map.put(GBP, RATE_GBP_TO_CNY);
        map.put(BTC, RATE_BTC_TO_CNY);
        return map;
    }

    /**
     * 转换汇率
     *
     * @param to 货币单位
     * @return 汇率
     */
    public double exchangeRateTo(Currency to) {
        return exchangeRateToCny() * to.exchangeRateFromCny();
    }

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

    private double exchangeRateFromCny() {
        return RATE_CNY / exchangeRateToCny();
    }
}
