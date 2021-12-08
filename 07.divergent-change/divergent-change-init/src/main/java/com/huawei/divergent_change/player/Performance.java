
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player;

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

    int getThisCredits() {
        int thisCredits = Math.max(audienceNum - 30, 0);
        if (PlayType.COMEDY.equals(type)) {
            thisCredits += Math.floor((double) audienceNum / 5);
        }
        return thisCredits;
    }

    int getThisAmount() {
        int thisAmount = 40000;
        if (audienceNum > 30) {
            thisAmount += 1000 * (audienceNum - 30);
        }
        return thisAmount;
    }
}
