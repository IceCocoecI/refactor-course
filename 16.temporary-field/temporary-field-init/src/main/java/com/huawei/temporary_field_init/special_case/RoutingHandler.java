/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field_init.special_case;

import java.util.ArrayList;
import java.util.List;

import com.huawei.temporary_field_init.special_case.router.NullRouter;
import com.huawei.temporary_field_init.special_case.router.Router;

/**
 * 路由消息处理
 *
 * @since 2021-08-05
 */
public class RoutingHandler {
    /**
     * 消息处理
     * 
     * @param messages 消息内容
     * @return 处理结果
     */
    public List<String> handle(Iterable<Message> messages) {
        List<String> handleResults = new ArrayList<>();
        for (Message msg : messages) {
            Router router = RouterFactory.getRouterForMessage(msg);
            handleResults.add(router.route(msg));
        }
        return handleResults;
    }

}