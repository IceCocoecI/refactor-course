/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.thirdparty.mysql;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟三方件提供的mysql数据库连接
 *
 * @since 2021-10-30
 */
public class MysqlConnection {
    /**
     * 模拟mysql的查询api（具体略）
     * 
     * @param sql sql语句
     * @param clazz 返回类型
     * @param <T> 类型
     * @return 查询结果
     */
    public <T> List<T> queryList(String sql, Class<T> clazz) {
        // queryList from database
        return new ArrayList<>();
    }

    /**
     * 模拟mysql的连接api
     * 
     * @param config 连接配置信息
     */
    public void connect(MysqlConfig config) {
        // connect database
    }

    /**
     * 模拟mysql的更新api
     *
     * @param sql sql语句
     */
    public void update(String sql) {
        // someUpdate
    }
}
