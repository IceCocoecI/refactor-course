/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.client;

import com.huawei.large_class.server.interfaces.WorkmanInfoGenerator;
import com.huawei.large_class.server.interfaces.dto.WorkmanInfoDto;
import com.huawei.large_class.server.processor.enums.Career;
import com.huawei.large_class.server.processor.enums.Gender;

/**
 * 调用client
 *
 * @since 2021-08-25
 */
public class LargeClassExample {
    public static void main(String[] args) {
        WorkmanInfoDto workmanInfoDto = new WorkmanInfoDto()
            .setName("zhangsan")
            .setGender(Gender.MALE)
            .setPhoneNumber("123456")
            .setEmail("xxx@xxx.com")
            .setWorkplace("xxxSchool")
            .setCareer(Career.TEACHER)
            .setSalary(10000)
            .setWeChat("weChat123")
            .setQQ("QQ123456");

        WorkmanInfoGenerator workmanInfoGenerator = new WorkmanInfoGenerator();
        System.out.println(workmanInfoGenerator.getWorkmanInfo(workmanInfoDto));
    }
}
