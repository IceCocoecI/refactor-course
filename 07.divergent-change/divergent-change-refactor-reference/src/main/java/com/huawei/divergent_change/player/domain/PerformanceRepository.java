/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player.domain;

import java.util.List;

/**
 * 演出信息持久化层接口
 *
 * @since 2021-11-05
 */
public interface PerformanceRepository {
    /**
     * 查询演出信息（具体sql略）
     *
     * @param playerId id
     * @return 演出信息
     */
    List<Performance> getPerformances(long playerId);

    /**
     * 添加演出（具体略）
     *
     * @param someId 某id
     * @param performances 演出
     */
    void addPerformances(long someId, List<Performance> performances);

    /**
     * 更新演出信息（具体sql略）
     *
     * @param performances 演出信息
     */
    void updatePerformances(List<Performance> performances);
}
