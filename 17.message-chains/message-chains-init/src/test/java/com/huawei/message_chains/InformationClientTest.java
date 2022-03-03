/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.message_chains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.huawei.message_chains.bean.Address;
import com.huawei.message_chains.bean.Department;
import com.huawei.message_chains.bean.Person;
import com.huawei.message_chains.bean.Street;

/**
 * InformationClient测试类
 *
 * @since 2021-11-11
 */
class InformationClientTest {

    private static Person person;

    @BeforeAll
    public static void init() {
        person = new Person(new Department(new Address(new Street("AliceRoad", 1001))));
    }

    @Test
    @DisplayName("确认责任链调用中构造的信息，街道名称正确的情况")
    public void should_return_ok_while_test_find_street_name() {
        InformationClient informationClient = new InformationClient();
        Assertions.assertEquals("AliceRoad", informationClient.getServerStreetName(person));
    }

    @Test
    @DisplayName("确认责任链调用中构造的信息，街道名称不正确的情况")
    public void should_return_not_ok_while_test_find_street_name() {
        InformationClient informationClient = new InformationClient();
        Assertions.assertNotEquals("NotOk", informationClient.getServerStreetName(person));
    }

    @Test
    @DisplayName("确认责任链调用中构造的信息，街道编号正确的情况")
    void should_return_ok_while_test_find_street_no() {
        InformationClient informationClient = new InformationClient();
        Assertions.assertEquals(1001, informationClient.getServerStreetNo(person));
    }

    @Test
    @DisplayName("确认责任链调用中构造的信息，街道编号不正确的情况")
    void should_return_not_ok_while_test_find_street_no() {
        InformationClient informationClient = new InformationClient();
        Assertions.assertNotEquals(-1, informationClient.getServerStreetNo(person));
    }
}