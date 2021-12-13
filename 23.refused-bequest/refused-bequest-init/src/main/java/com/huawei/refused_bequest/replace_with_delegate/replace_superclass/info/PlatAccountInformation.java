/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.replace_with_delegate.replace_superclass.info;

import java.sql.Timestamp;

/**
 * @filename: UserInformation
 * @description: 平台用户所需信息
 */
public class PlatAccountInformation {
    private final PersonalInformation personalInformation = new PersonalInformation();

    private String account;

    private String password;

    private Timestamp loginTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

}