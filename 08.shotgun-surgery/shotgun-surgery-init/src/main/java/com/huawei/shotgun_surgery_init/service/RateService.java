/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.service;

import com.huawei.shotgun_surgery_init.model.Currency;

import java.text.MessageFormat;
import java.util.Map;

/**
 * 汇率服务
 *
 * @since 2021-11-16
 */
public class RateService {
    /**
     * 查询所有币种兑人民币汇率
     *
     * @return 汇率集合
     */
    public Map<Currency, Double> queryAllRatesToCny() {
        return Currency.getCurrencyDoubleMap();
    }

    /**
     * 币种间汇率转换
     *
     * @param from 转换前币种
     * @param to 转换后币种
     * @return 汇率转换结果
     */
    public double queryExchangeRate(Currency from, Currency to) {
        doSomeBusiness(from, to);
        return exchangeRateToCny(from) / exchangeRateToCny(to);
    }

    /**
     * 转换为兑人民币汇率
     *
     * @param from 转换币种
     * @return 汇率
     */
    private double exchangeRateToCny(Currency from) {
        switch (from) {
            case CNY:
                return 1.0;
            case USD:
                return 6.8;
            case GBP:
                return 9.6;
            case BTC:
                return 60000.0;
            default:
                throw new IllegalArgumentException(MessageFormat.format("unsupported exchange {0} to CNY", from));
        }
    }

    private void doSomeBusiness(Currency from, Currency to) {
        // do some business
    }
}
