/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field_init.special_case.router;

import com.huawei.temporary_field_init.special_case.Message;

/**
 * 功能描述
 *
 * @since 2021-12-10
 */
public class NullRouter implements Router {
    @Override
    public String route(Message body) {
        return "priority is null, handle failed";
    }
}
