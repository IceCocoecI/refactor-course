
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.player;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

        int totalAmount = 0;
        int volumeCredits = 0;


        for (Performance perf : performances) {
            totalAmount += getThisAmount(perf);

            volumeCredits += getThisCredits(perf);
        }

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String result = String.format("Statement for %s\n", playerId);
        result += String.format("Performances you've participated in :%s\n",
            performances.stream().map(Performance::getName).collect(Collectors.toList()));
        result += String.format("You earned %s\n", format.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }

    private int getThisCredits(Performance perf) {
        int thisCredits = Math.max(perf.getAudienceNum() - 30, 0);
        if (PlayType.COMEDY.equals(perf.getType())) {
            thisCredits += Math.floor((double) perf.getAudienceNum() / 5);
        }
        return thisCredits;
    }

    private int getThisAmount(Performance perf) {
        int thisAmount = 40000;
        if (perf.getAudienceNum() > 30) {
            thisAmount += 1000 * (perf.getAudienceNum() - 30);
        }
        return thisAmount;
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
