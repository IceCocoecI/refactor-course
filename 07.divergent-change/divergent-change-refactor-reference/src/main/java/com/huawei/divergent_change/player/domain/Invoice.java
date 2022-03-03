/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player.domain;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * 发票信息
 *
 * @since 2021-10-30
 */
public class Invoice {
    private final long playerId;

    private final List<Performance> performances;

    public Invoice(long playerId, List<Performance> performances) {
        this.playerId = playerId;
        this.performances = performances;
    }

    /**
     * 获取发票详情
     * 
     * @return 发票详情
     */
    public String getInvoiceDetail() {
        int totalAmount = performances.stream().mapToInt(Performance::getThisAmount).sum();

        int volumeCredits = performances.stream().mapToInt(Performance::getThisCredits).sum();

        return printInvoiceData(totalAmount, volumeCredits);
    }

    /**
     * 打印发票详情
     * 
     * @param totalAmount 金额
     * @param volumeCredits 积分
     * @return 发票详情
     */
    private String printInvoiceData(int totalAmount, int volumeCredits) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String result = String.format("Statement for %s\n", playerId);
        result += String.format("Performances you've participated in :%s\n",
            performances.stream().map(Performance::getName).collect(Collectors.toList()));
        result += String.format("You earned %s\n", format.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }
}