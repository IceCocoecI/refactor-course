/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.shotgun_surgery_init.model;

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

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money add(Money increase) {
        final double rate = increase.getCurrency().exchangeRate(getCurrency());
        final double finalSalary = getAmount() + increase.getAmount() * rate;
        return new Money(finalSalary, getCurrency());
    }
}
