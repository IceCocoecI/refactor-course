/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player.adapter.infrastructure;

import java.util.List;

import com.huawei.divergent_change.player.domain.Performance;
import com.huawei.divergent_change.player.domain.PerformanceRepository;
import com.huawei.divergent_change.thirdparty.mysql.MysqlConfig;
import com.huawei.divergent_change.thirdparty.mysql.MysqlConnection;

/**
 * 演出信息持久化层mql实现
 *
 * @since 2021-11-05
 */
public class PerformanceRepositoryImpl implements PerformanceRepository {
    private static MysqlConnection mysqlConnection;

    /**
     * 创建连接
     * 
     * @param mysqlConfig mysql配置
     */
    public static void createConnection(MysqlConfig mysqlConfig) {
        if (mysqlConnection != null) {
            return;
        }
        mysqlConnection = new MysqlConnection();
        mysqlConnection.connect(mysqlConfig);
    }

    @Override
    public List<Performance> getPerformances(long playerId) {
        String sql = "select xxx where playerId = " + playerId;
        return mysqlConnection.queryList(sql, Performance.class);
    }

    @Override
    public void addPerformances(long someId, List<Performance> performances) {
        String sql = "insert into xxx …… " + performances + "xxx" + someId;
        mysqlConnection.update(sql);
    }

    @Override
    public void updatePerformances(List<Performance> performances) {
        String sql = "update xxx set xxxx …… " + performances;
        mysqlConnection.update(sql);
    }
}
