
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_clumps_init;

import static com.huawei.data_clumps_init.personInfo.constant.Constant.LINE_SEPARATOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.huawei.data_clumps_init.personInfo.PersonInfoManage;
import com.huawei.data_clumps_init.personInfo.model.Address;
import com.huawei.data_clumps_init.personInfo.model.Gender;
import com.huawei.data_clumps_init.personInfo.model.Name;

/**
 * PersonInfoManage测试类
 *
 * @since 2021-11-03
 */
class PersonInfoManageTest {
    @Test
    void should_get_PersonName_when_getName() {
        PersonInfoManage personInfoManage =
            new PersonInfoManage(new Name("San", "Zhang"), Gender.MALE, new Address("Sichuan", "Chengdu", "someStreet"));

        final String name = personInfoManage.getName();

        final String expectedName = "First Name: San" + LINE_SEPARATOR + "Last Name: Zhang";
        assertEquals(expectedName, name);
    }

    @Test
    void should_get_updatedPersonAddress_when_updateAddress() {
        PersonInfoManage personInfoManage =
            new PersonInfoManage(new Name("SiRui", "Zhang"), Gender.FEMALE, new Address("Sichuan", "Chengdu", "someStreet"));

        final String address = personInfoManage.getAddress();
        personInfoManage.updateAddress(new Address("Jiangsu", "Nanjing", "anotherStreet"));
        final String updatedAddress = personInfoManage.getAddress();

        final String expectedAddress =
            "Province: Sichuan" + LINE_SEPARATOR + "City: Chengdu" + LINE_SEPARATOR + "Street: someStreet";
        assertEquals(expectedAddress, address);
        final String expectedUpdatedAddress =
            "Province: Jiangsu" + LINE_SEPARATOR + "City: Nanjing" + LINE_SEPARATOR + "Street: anotherStreet";
        assertEquals(expectedUpdatedAddress, updatedAddress);
    }

    @Test
    void should_get_moveResult_when_moveToAnotherPlace() {
        PersonInfoManage personInfoManage =
            new PersonInfoManage(new Name("San", "Zhang"), Gender.MALE, new Address("Sichuan", "Chengdu", "someStreet"));

        final String mailResult = personInfoManage.moveToAnotherPlace(new Address("Jiangsu", "Nanjing", "anotherStreet"));

        String expectedMailResult = "move from: " + LINE_SEPARATOR
            + "\tSichuan Chengdu someStreet" + LINE_SEPARATOR
            + "to: " + LINE_SEPARATOR
            + "\tJiangsu Nanjing anotherStreet";
        assertEquals(expectedMailResult, mailResult);
    }
}
