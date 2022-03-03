/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.divergent_change.thirdparty.gauss;

/**
 * 模拟三方件提供的gauss数据库连接
 *
 * @since 2021-10-30
 */
public class GaussConnection {
    /**
     * 模拟gauss的查询api（具体略）
     * 
     * @param sql sql
     * @return 查询结果
     */
    public Object executeQuery(String sql) {
        // query from database
        return new Object();
    }

    /**
     * 模拟gauss的连接api（具体略）
     * 
     * @param gaussConfig gauss连接
     */
    public void connect(GaussConfig gaussConfig) {
        // connect database
    }

    /**
     * 模拟gauss的更新操作api（具体略）
     *
     * @param sql sql
     * @return 更新结果
     */
    public int update(String sql) {
        // someUpdate
        return 0;
    }
}
