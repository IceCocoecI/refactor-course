/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.replace_with_delegate.replace_subclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.huawei.refused_bequest.replace_with_delegate.replace_subclass.info.PlatAccountInformation;
import com.huawei.refused_bequest.replace_with_delegate.replace_subclass.view.PublicPlatView;

/**
 * @filename: PublicPlatViewTest
 * @description: PublicPlatViewTest测试用例
 */
public class PublicPlatViewTest {
    private static PlatAccountInformation platAccountInformation;

    @BeforeAll
    static void init() {
        platAccountInformation = new PlatAccountInformation();
        platAccountInformation.getPersonalInformation().setName("李华");
        platAccountInformation.getPersonalInformation().setAge(25);
        platAccountInformation.getPersonalInformation().setMobile("13555555555");
        platAccountInformation.setAccount("LiHua001");
        platAccountInformation.setPassword("ZmRzYWZkc2FmY2RzYWN3Y3djemNhY2U=");
        platAccountInformation.setLoginTime(new Timestamp(1635749765316L));
    }

    @Test
    void should_get_PublicPlat_info() {
        PublicPlatView publicPlatView = new PublicPlatView();
        Map<String, Object> viewMap = publicPlatView.getPublicPlatView(platAccountInformation);
        assertEquals("LiHua001", viewMap.get("Account"));
        assertEquals("李华", viewMap.get("Name"));
        assertEquals("13555555555", viewMap.get("Mobile"));
        Timestamp timestamp = new Timestamp(1635749765316L);
        assertEquals(timestamp, viewMap.get("LoginTime"));
    }
}
