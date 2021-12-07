package com.huawei.divergent_change.player;

import java.util.List;

public class Invoice {
    private final long playerId;
    private final List<Performance> performances;

    public Invoice(long playerId, List<Performance> performances) {
        this.playerId = playerId;
        this.performances = performances;
    }

    public long getPlayerId() {
        return playerId;
    }

    public List<Performance> getPerformances() {
        return performances;
    }
}
