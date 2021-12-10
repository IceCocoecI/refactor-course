/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.processor.model;

public class Contacts {
    private final String phoneNumber;
    private final String email;
    private final String weChat;
    private final String QQ;

    public Contacts(String phoneNumber, String email, String weChat, String QQ) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.weChat = weChat;
        this.QQ = QQ;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getWeChat() {
        return weChat;
    }

    public String getQQ() {
        return QQ;
    }
}
