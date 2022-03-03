/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field.special_case.router;

import com.huawei.temporary_field.special_case.Message;

/**
 * Sms路由
 *
 * @since 2021-08-05
 */
public class SmsRouter implements Router {
    @Override
    public String route(Message msg) {
        return "Routing to a SMS gateway. Msg: " + msg;
    }
}
