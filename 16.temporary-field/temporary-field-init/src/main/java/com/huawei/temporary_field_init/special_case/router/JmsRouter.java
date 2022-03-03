/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field_init.special_case.router;

import com.huawei.temporary_field_init.special_case.Message;

/**
 * Jms路由
 *
 * @since 2021-08-05
 */
public class JmsRouter implements Router {
    @Override
    public String route(Message msg) {
        return "Routing to a JMS queue. Msg: " + msg;
    }
}
