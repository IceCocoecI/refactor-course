/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.model;

import static com.huawei.shotgun_surgery_init.model.Currency.CNY;
import static com.huawei.shotgun_surgery_init.model.Currency.GBP;
import static com.huawei.shotgun_surgery_init.model.Currency.USD;

import java.util.Arrays;
import java.util.List;

/**
 * 是否支持currency的校验
 *
 * @since 2021-11-12
 */
public class SupportedCurrencyChecker {
    private final static List<Currency> SUPPORTED_CURRENCY = Arrays.asList(CNY, USD, GBP);

    /**
     * 校验是否支持输入的币种
     *
     * @param currency 币种
     */
    public boolean isSupported(Currency currency) {
        return SUPPORTED_CURRENCY.contains(currency);
    }
}
