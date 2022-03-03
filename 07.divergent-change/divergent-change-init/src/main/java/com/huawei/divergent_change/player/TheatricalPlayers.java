
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player;

import java.util.List;

/**
 * 戏剧演员
 *
 * @since 2021-10-30
 */
public class TheatricalPlayers {

    private final PerformanceRepository performanceRepository;

    public TheatricalPlayers(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    /**
     * 剧种类别
     */
    public enum PlayType {
        COMEDY,
        TRAGEDY
    }

    /**
     * 获取发票信息
     * 
     * @param playerId 演员id
     * @return 发票信息
     */
    public String getInvoiceData(long playerId) {
        List<Performance> performances = performanceRepository.getPerformances(playerId);

        return new Invoice(playerId, performances).getInvoiceDetail();
    }

    /**
     * 某类涉及数据库操作的业务处理
     * 
     * @param someParam 某参数
     * @param performances 演出信息
     */
    public void someBusinessProcess(long someParam, List<Performance> performances) {
        // do some business
        performanceRepository.addPerformances(someParam, performances);
        // do some business
        performanceRepository.updatePerformances(performances);
    }

}
