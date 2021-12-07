
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player;

import com.huawei.divergent_change.player.TheatricalPlayers.PlayType;

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

    public PlayType getType() {
        return type;
    }

    public int getAudienceNum() {
        return audienceNum;
    }

    int getThisCredits() {
        int thisCredits = Math.max(getAudienceNum() - 30, 0);
        if (PlayType.COMEDY.equals(getType())) {
            thisCredits += Math.floor((double) getAudienceNum() / 5);
        }
        return thisCredits;
    }

    int getThisAmount() {
        int thisAmount = 40000;
        if (getAudienceNum() > 30) {
            thisAmount += 1000 * (getAudienceNum() - 30);
        }
        return thisAmount;
    }
}
