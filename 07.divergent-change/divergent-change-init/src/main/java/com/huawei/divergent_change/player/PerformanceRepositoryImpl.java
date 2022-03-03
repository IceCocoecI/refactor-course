package com.huawei.divergent_change.player;

import java.util.List;

import com.huawei.divergent_change.thirdparty.mysql.MysqlConfig;
import com.huawei.divergent_change.thirdparty.mysql.MysqlConnection;

/**
 * 功能描述
 *
 * @since 2021-12-08
 */
public class PerformanceRepositoryImpl implements PerformanceRepository {
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
     * 添加演出（具体略）
     *
     * @param someId 某id
     * @param performances 演出
     */
    @Override
    public void addPerformances(long someId, List<Performance> performances) {
        String sql = "insert into xxx …… " + performances + "xxx" + someId;
        mysqlConnection.update(sql);
    }

    /**
     * 查询演出信息（具体sql略）
     *
     * @param playerId id
     * @return 演出信息
     */
    @Override
    public List<Performance> getPerformances(long playerId) {
        String sql = "select xxx where playerId = " + playerId;
        return mysqlConnection.queryList(sql, Performance.class);
    }

    /**
     * 更新演出信息（具体sql略）
     *
     * @param performances 演出信息
     */
    @Override
    public void updatePerformances(List<Performance> performances) {
        String sql = "update xxx set xxxx …… " + performances;
        mysqlConnection.update(sql);
    }
}
