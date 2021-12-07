
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player;

import java.util.List;

import com.huawei.divergent_change.thirdparty.mysql.MysqlConfig;
import com.huawei.divergent_change.thirdparty.mysql.MysqlConnection;

/**
 * 戏剧演员
 *
 * @since 2021-10-30
 */
public class TheatricalPlayers {
    private static MysqlConnection mysqlConnection;

    /**
     * 创建数据库连接
     * 
     * @param mysqlConfig 数据库配置信息
     */
    public static void createConnection(MysqlConfig mysqlConfig) {
        if (mysqlConnection != null) {
            return;
        }
        mysqlConnection = new MysqlConnection();
        mysqlConnection.connect(mysqlConfig);
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
        List<Performance> performances = getPerformances(playerId);

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
        addPerformances(someParam, performances);
        // do some business
        updatePerformances(performances);
    }

    /**
     * 更新演出信息（具体sql略）
     * 
     * @param performances 演出信息
     */
    public void updatePerformances(List<Performance> performances) {
        String sql = "update xxx set xxxx …… " + performances;
        mysqlConnection.update(sql);
    }

    /**
     * 查询演出信息（具体sql略）
     *
     * @param playerId id
     * @return 演出信息
     */
    public List<Performance> getPerformances(long playerId) {
        String sql = "select xxx where playerId = " + playerId;
        return mysqlConnection.queryList(sql, Performance.class);
    }

    /**
     * 添加演出（具体略）
     * 
     * @param someId 某id
     * @param performances 演出
     */
    public void addPerformances(long someId, List<Performance> performances) {
        String sql = "insert into xxx …… " + performances + "xxx" + someId;
        mysqlConnection.update(sql);
    }
}
