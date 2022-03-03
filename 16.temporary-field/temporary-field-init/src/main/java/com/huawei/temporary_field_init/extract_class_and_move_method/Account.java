/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field_init.extract_class_and_move_method;

/**
 * 账户信息
 *
 * @since 2021-08-05
 */
public class Account {
    private final String name;

    private final String cardId;

    private int balance;

    // other account info ……

    private int maxAsset;

    private double usageFrequency;

    private int overdueTimes;

    public Account(String name, String cardId, int balance) {
        this.name = name;
        this.cardId = cardId;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getCardId() {
        return cardId;
    }

    /**
     * 增加到余额
     * 
     * @param money 增加金额
     */
    public void addToBalance(int money) {
        balance += money;
    }

    /**
     * 扣除余额
     * 
     * @param money 扣除金额
     */
    public void deductBalance(int money) {
        balance -= money;
    }

    public int getBalance() {
        return balance;
    }

    // other account info process

    /**
     * 整体评估
     * 
     * @return 评估结果
     */
    public int evaluateAccount() {
        int evaluatePoint = 60;
        int usageTimes = (int) (usageFrequency * 365) + 1;
        double overdueRate = (double) overdueTimes / usageTimes;
        evaluatePoint -= 10 * overdueRate;
        evaluatePoint += (maxAsset / 100);
        return evaluatePoint;
    }

    /**
     * 消费水平评估
     * 
     * @return 评估结果
     */
    public int evaluateConsumptionLevel() {
        return (int) (usageFrequency * 365) - overdueTimes * 3;
    }

    public void setMaxAsset(int maxAsset) {
        this.maxAsset = maxAsset;
    }

    public void setUsageFrequency(double usageFrequency) {
        this.usageFrequency = usageFrequency;
    }

    public void setOverdueTimes(int overdueTimes) {
        this.overdueTimes = overdueTimes;
    }
}
