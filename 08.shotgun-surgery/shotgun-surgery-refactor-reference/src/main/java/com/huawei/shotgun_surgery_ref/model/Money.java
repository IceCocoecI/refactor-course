/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_ref.model;

import java.text.MessageFormat;

/**
 * 货币
 *
 * @since 2021-11-02
 */
public class Money {
    private final double amount;

    private final Currency currency;

    public Money(double amount, Currency currency) {
        if (!currency.isSupported()) {
            throw new IllegalArgumentException(
                MessageFormat.format("pay with Currency={0} is not supported", currency));
        }
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * 增加
     *
     * @param increase 增加幅度
     * @return 增加后结果
     */
    public Money add(Money increase) {
        final double rate = increase.currency.exchangeRateTo(currency);
        final double amount = this.amount + increase.amount * rate;
        return new Money(amount, currency);
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
