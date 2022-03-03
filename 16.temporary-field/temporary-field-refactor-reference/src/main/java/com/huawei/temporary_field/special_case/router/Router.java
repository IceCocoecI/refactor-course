/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field.special_case.router;

import com.huawei.temporary_field.special_case.Message;

/**
 * 路由接口
 *
 * @since 2021-08-05
 */
public interface Router {
    /**
     * 发送消息
     * 
     * @param body 消息体
     * @return 路由结果
     */
    String route(Message body);
}