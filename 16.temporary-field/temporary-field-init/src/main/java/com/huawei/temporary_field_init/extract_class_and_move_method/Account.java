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
    private final Evaluator evaluator = new Evaluator();

    private int balance;

    // other account info ……

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

    public Evaluator getEvaluator() {
        return evaluator;
    }
}
