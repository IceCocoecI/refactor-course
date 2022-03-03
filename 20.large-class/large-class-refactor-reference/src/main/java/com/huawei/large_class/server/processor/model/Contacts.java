/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.server.processor.model;

import static com.huawei.large_class.server.processor.constant.Constant.LINE_SEPARATOR;

/**
 * 联系方式
 *
 * @since 2021-08-25
 */
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

    /**
     * 获取联系方式
     *
     * @return 联系方式
     */
    public String getContactInfo() {
        return LINE_SEPARATOR
            + "\tphoneNumber: " + phoneNumber + LINE_SEPARATOR
            + "\temail: " + email + LINE_SEPARATOR
            + "\tweChat: " + weChat + LINE_SEPARATOR
            + "\tQQ: " + QQ;
    }
}
