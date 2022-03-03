/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.replace_with_delegate.replace_subclass.view;

import java.util.HashMap;
import java.util.Map;

import com.huawei.refused_bequest.replace_with_delegate.replace_subclass.info.PersonalInformation;

/**
 * @filename: ClientView
 * @description: 用户平台展示类
 */
public class PublicPlatView {
    /**
     * 获取平台所需信息
     *
     * @param personalInformation 平台用户信息
     * @return map 平台用户view信息
     */
    public Map<String, Object> getPublicPlatView(PersonalInformation personalInformation) {
        Map<String, Object> viewMap = new HashMap<>();
        viewMap.put("Account", personalInformation.getAccount());
        viewMap.put("Name", personalInformation.getName());
        viewMap.put("Mobile", personalInformation.getMobile());
        viewMap.put("LoginTime", personalInformation.getLoginTime());
        return viewMap;
    }
}
