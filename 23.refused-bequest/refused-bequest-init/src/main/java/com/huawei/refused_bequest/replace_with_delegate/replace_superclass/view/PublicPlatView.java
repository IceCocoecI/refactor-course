/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.replace_with_delegate.replace_superclass.view;

import java.util.HashMap;
import java.util.Map;

import com.huawei.refused_bequest.replace_with_delegate.replace_superclass.info.PlatAccountInformation;

/**
 * @filename: ClientView
 * @description: 用户平台展示类
 */
public class PublicPlatView {
    /**
     * 获取平台所需信息
     *
     * @param platAccountInformation 平台用户信息
     * @return map 平台用户view信息
     */
    public Map<String, Object> getPublicPlatView(PlatAccountInformation platAccountInformation) {
        Map<String, Object> viewMap = new HashMap<>();
        viewMap.put("Account", platAccountInformation.getAccount());
        viewMap.put("Name", platAccountInformation.getName());
        viewMap.put("Mobile", platAccountInformation.getMobile());
        viewMap.put("LoginTime", platAccountInformation.getLoginTime());
        return viewMap;
    }
}
