package com.huawei.temporary_field_init.special_case.router;

import com.huawei.temporary_field_init.special_case.Message;

/**
 * 功能描述
 *
 * @since 2021-12-10
 */
public class NullRouter implements Router {
    public static String nullRoute(Message msg) {
        return "priority is null, handle failed";
    }

    @Override
    public String route(Message body) {
        return nullRoute(body);
    }
}
