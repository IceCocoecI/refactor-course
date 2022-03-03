/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.data_clumps_init;

import com.huawei.data_clumps_init.personInfo.PersonInfoManage;
import com.huawei.data_clumps_init.personInfo.model.Gender;

/**
 * 模拟客户端
 *
 * @since 2021-11-05
 */
public class Client {
    public static void main(String[] args) {
        PersonInfoManage personInfoManage =
            new PersonInfoManage("San", "Zhang", Gender.MALE, "Sichuan", "Chengdu", "someStreet");

        System.out.println(personInfoManage.getName());
        System.out.println(personInfoManage.getGender());
        System.out.println(personInfoManage.getAddress());
        System.out.println(personInfoManage.moveToAnotherPlace("Jiangsu", "Nanjing", "anotherStreet"));
    }
}
