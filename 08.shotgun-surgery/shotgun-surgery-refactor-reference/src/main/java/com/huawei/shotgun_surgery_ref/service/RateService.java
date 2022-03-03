/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.service;

import static com.huawei.shotgun_surgery_ref.model.Currency.getAllRates;

import com.huawei.shotgun_surgery_ref.model.Currency;

import java.util.Map;

/**
 * 汇率服务
 *
 * @since 2021-11-16
 */
public class RateService {
    /**
     * 转换汇率
     *
     * @param from 转换前币种
     * @param to 转换后币种
     * @return 汇率
     */
    public double queryExchangeRate(Currency from, Currency to) {
        doSomeBusiness(from, to);
        return from.exchangeRateTo(to);
    }

    /**
     * 查询所有的币种兑人民币汇率
     *
     * @return 汇率Map
     */
    public Map<Currency, Double> queryAllRatesToCny() {
        return getAllRates();
    }

    private void doSomeBusiness(Currency from, Currency to) {
        // do some business
    }
}
