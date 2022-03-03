/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.temporary_field.special_case;

/**
 * 传送消息
 *
 * @since 2021-08-05
 */
public class Message {
    private String body;

    private String priority;

    public Message(String body, String priority) {
        this.body = body;
        this.priority = priority;
    }

    public String getBody() {
        return body;
    }

    public String getPriority() {
        return priority;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "{body='" + body + '\'' +
            ", priority='" + priority + '\'' +
            '}';
    }
}
