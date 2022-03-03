/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player.adapter;

import java.util.ArrayList;

import com.huawei.divergent_change.player.adapter.infrastructure.PerformanceRepositoryImpl;
import com.huawei.divergent_change.player.application.usecase.TheatricalPlayers;
import com.huawei.divergent_change.player.domain.PerformanceRepository;
import com.huawei.divergent_change.thirdparty.mysql.MysqlConfig;

/**
 * 模拟的对外接口，如rest、rpc、api等，此次重构仅为表示分层，无需关注
 *
 * @since 2021-11-05
 */
public class TheatricalPlayersApi {
    private final TheatricalPlayers theatricalPlayers;

    public TheatricalPlayersApi() {
        PerformanceRepository performanceRepository = new PerformanceRepositoryImpl();
        PerformanceRepositoryImpl.createConnection(new MysqlConfig());
        this.theatricalPlayers = new TheatricalPlayers(performanceRepository);
    }

    /**
     * 获取发票信息的api（具体略）
     *
     * @param someParam 某些入参
     * @return 发票信息（具体略）
     */
    public String getInvoiceData(Object someParam) {
        // param check
        // param convert
        return theatricalPlayers.getInvoiceData(0);
    }

    /**
     * 某些业务处理（具体略）
     *
     * @param someParam 某些入参
     */
    public void someBusinessProcess(Object someParam) {
        // param check
        // param convert
        theatricalPlayers.someBusinessProcess(0, new ArrayList<>());
    }
}
