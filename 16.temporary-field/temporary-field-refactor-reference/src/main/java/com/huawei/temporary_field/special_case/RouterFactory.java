/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field.special_case;

import com.huawei.temporary_field.special_case.router.DefaultRouter;
import com.huawei.temporary_field.special_case.router.JmsRouter;
import com.huawei.temporary_field.special_case.router.NullRouter;
import com.huawei.temporary_field.special_case.router.Router;
import com.huawei.temporary_field.special_case.router.SmsRouter;

/**
 * 路由方式工厂
 *
 * @since 2021-08-05
 */
public class RouterFactory {
    /**
     * 获取路由消息的方法
     * 
     * @param msg 消息体
     * @return 路由方法实例
     */
    public static Router getRouterForMessage(Message msg) {
        switch (String.valueOf(msg.getPriority())) {
            case "high":
                return new SmsRouter();
            case "medium":
                return new JmsRouter();
            case "null":
                return new NullRouter();
            default:
                return new DefaultRouter();
        }
    }
}