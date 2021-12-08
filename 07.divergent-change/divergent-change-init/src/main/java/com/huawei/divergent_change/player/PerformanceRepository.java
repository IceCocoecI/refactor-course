package com.huawei.divergent_change.player;

import java.util.List;

/**
 * 功能描述
 *
 * @since 2021-12-08
 */
public interface PerformanceRepository {
    void addPerformances(long someId, List<Performance> performances);

    List<Performance> getPerformances(long playerId);

    void updatePerformances(List<Performance> performances);
}
