
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player.domain;

/**
 * 演出信息
 *
 * @since 2021-10-30
 */
public class Performance {
    private final String name;

    private final PlayType type;

    private final int audienceNum;

    public Performance(String name, PlayType type, int audienceNum) {
        this.name = name;
        this.type = type;
        this.audienceNum = audienceNum;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取当前演出收入
     * 
     * @return 演出收入
     */
    public int getThisAmount() {
        int thisAmount = 40000;
        if (audienceNum > 30) {
            thisAmount += 1000 * (audienceNum - 30);
        }
        return thisAmount;
    }

    /**
     * 获取当前演出积分
     * 
     * @return 演出积分
     */
    public int getThisCredits() {
        int thisCredits = Math.max(audienceNum - 30, 0);
        if (PlayType.COMEDY.equals(type)) {
            thisCredits += Math.floor((double) audienceNum / 5);
        }
        return thisCredits;
    }
}
