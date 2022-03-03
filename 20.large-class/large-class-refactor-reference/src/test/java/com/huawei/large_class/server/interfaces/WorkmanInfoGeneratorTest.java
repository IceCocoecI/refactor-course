/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.server.interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.huawei.large_class.server.interfaces.dto.WorkmanInfoDto;
import com.huawei.large_class.server.processor.enums.Career;
import com.huawei.large_class.server.processor.enums.Gender;

/**
 * 生成工作人员信息测试
 *
 * @since 2021-08-25
 */
public class WorkmanInfoGeneratorTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void should_get_teacherInfo_given_profession_is_TEACHER() {
        WorkmanInfoDto workmanInfoDto = new WorkmanInfoDto()
            .setName("zhangSan")
            .setGender(Gender.MALE)
            .setPhoneNumber("123456")
            .setEmail("xxx@xxx.com")
            .setWorkplace("xxxSchool")
            .setCareer(Career.TEACHER)
            .setSalary(10000)
            .setWeChat("weChat123")
            .setQQ("QQ123456");

        WorkmanInfoGenerator workmanInfoGenerator = new WorkmanInfoGenerator();
        String personInfo = workmanInfoGenerator.getWorkmanInfo(workmanInfoDto);

        String expected = "basic info: " + LINE_SEPARATOR +
            "\tname: zhangSan" + LINE_SEPARATOR +
            "\tgender: MALE" + LINE_SEPARATOR +
            "contact info: " + LINE_SEPARATOR +
            "\tphoneNumber: 123456" + LINE_SEPARATOR +
            "\temail: xxx@xxx.com" + LINE_SEPARATOR +
            "\tweChat: weChat123" + LINE_SEPARATOR +
            "\tQQ: QQ123456" + LINE_SEPARATOR +
            "teachers' hopes: Every student can grow sturdily and get good grades" + LINE_SEPARATOR +
            "school: xxxSchool" + LINE_SEPARATOR +
            "Salary after 2 years: 11664.0";
        assertEquals(expected, personInfo);
    }

    @Test
    public void should_get_doctorInfo_given_profession_is_DOCTOR() {
        WorkmanInfoDto workmanInfoDto = new WorkmanInfoDto()
            .setName("wangWu")
            .setGender(Gender.FEMALE)
            .setPhoneNumber("987654321")
            .setEmail("ccc@ddd.com")
            .setWorkplace("xxxHospital")
            .setCareer(Career.DOCTOR)
            .setSalary(10000)
            .setWeChat("weChat333")
            .setQQ("QQ12345678");

        WorkmanInfoGenerator workmanInfoGenerator = new WorkmanInfoGenerator();
        String personInfo = workmanInfoGenerator.getWorkmanInfo(workmanInfoDto);

        String expected = "basic info: " + LINE_SEPARATOR +
            "\tname: wangWu" + LINE_SEPARATOR +
            "\tgender: FEMALE" + LINE_SEPARATOR +
            "contact info: " + LINE_SEPARATOR +
            "\tphoneNumber: 987654321" + LINE_SEPARATOR +
            "\temail: ccc@ddd.com" + LINE_SEPARATOR +
            "\tweChat: weChat333" + LINE_SEPARATOR +
            "\tQQ: QQ12345678" + LINE_SEPARATOR +
            "hospital: xxxHospital" + LINE_SEPARATOR +
            "doctors' duties: A doctor's work is to heal and save lives" + LINE_SEPARATOR +
            "Salary after 3 years: 13310.0";
        assertEquals(expected, personInfo);
    }

    @Test
    public void should_get_invalidInfo_given_profession_is_null() {
        WorkmanInfoDto workmanInfoDto = new WorkmanInfoDto()
            .setName("hhh")
            .setGender(Gender.MALE)
            .setPhoneNumber("123456")
            .setEmail("xxx@xxx.com")
            .setWorkplace("xxxSchool")
            .setCareer(null)
            .setSalary(10000)
            .setWeChat("weChat123")
            .setQQ("QQ123456");

        WorkmanInfoGenerator workmanInfoGenerator = new WorkmanInfoGenerator();
        String personInfo = workmanInfoGenerator.getWorkmanInfo(workmanInfoDto);

        String expected = "invalidPersonInfo";
        assertEquals(expected, personInfo);
    }
}