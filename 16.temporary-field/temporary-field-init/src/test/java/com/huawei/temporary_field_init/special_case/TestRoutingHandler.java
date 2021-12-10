/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field_init.special_case;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * RoutingHandler测试
 *
 * @since 2021-08-05
 */
public class TestRoutingHandler {
    @Test
    public void testHandle() {
        RoutingHandler routingHandler = new RoutingHandler();
        List<String> expectHandleResults = Arrays.asList(
            "Routing to a SMS gateway. Msg: {body='Alert!', priority='high'}",
            "Routing to a JMS queue. Msg: {body='Warning!', priority='medium'}",
            "Routing to a Default cache. Msg: {body='Take a look!', priority='low'}",
            "priority is null, handle failed",
            "priority is null, handle failed",
            "Routing to a Default cache. Msg: {body='null', priority='low'}");
        Message highPriorityMsg = new Message("Alert!", "high");
        Message mediumPriorityMsg = new Message("Warning!", "medium");
        Message lowPriorityMsg = new Message("Take a look!", "low");
        Message nullMessage = new Message(null, null);
        Message nullPriorityMessage = new Message("useless", null);
        Message nullBodyMessage = new Message(null, "low");

        List<Message> messages = Arrays.asList(highPriorityMsg,
            mediumPriorityMsg,
            lowPriorityMsg,
            nullMessage,
            nullPriorityMessage,
            nullBodyMessage);
        System.out.println(Arrays.toString(routingHandler.handle(messages).toArray()));
        assertEquals(expectHandleResults,
            routingHandler.handle(messages));
    }
}
