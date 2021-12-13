/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.processor.model;

import static com.huawei.large_class_init.server.processor.constant.Constant.LINE_SEPARATOR;

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

    public String getContactInfo() {
        return LINE_SEPARATOR
            + "\tphoneNumber: " + phoneNumber + LINE_SEPARATOR
            + "\temail: " + email + LINE_SEPARATOR
            + "\tweChat: " + weChat + LINE_SEPARATOR
            + "\tQQ: " + QQ;
    }
}
