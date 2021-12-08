/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player.domain;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Invoice {
    private final long playerId;

    private final List<Performance> performances;

    public Invoice(long playerId, List<Performance> performances) {
        this.playerId = playerId;
        this.performances = performances;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public String getInvoiceDetail() {
        int totalAmount = getPerformances().stream().mapToInt(Performance::getThisAmount).sum();

        int volumeCredits = getPerformances().stream().mapToInt(Performance::getThisCredits).sum();

        return printInvoiceData(totalAmount, volumeCredits);
    }

    private String printInvoiceData(int totalAmount, int volumeCredits) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String result = String.format("Statement for %s\n", playerId);
        result += String.format("Performances you've participated in :%s\n",
            getPerformances().stream().map(Performance::getName).collect(Collectors.toList()));
        result += String.format("You earned %s\n", format.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }
}
