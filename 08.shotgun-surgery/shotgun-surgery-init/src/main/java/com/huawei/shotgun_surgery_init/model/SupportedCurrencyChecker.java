/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.model;

/**
 * 是否支持currency的校验
 *
 * @since 2021-11-12
 */
public class SupportedCurrencyChecker {

    /**
     * 校验是否支持输入的币种
     *
     * @param currency 币种
     */
    public boolean isSupported(Currency currency) {
        return Currency.SUPPORTED_CURRENCY.contains(currency);
    }
}
