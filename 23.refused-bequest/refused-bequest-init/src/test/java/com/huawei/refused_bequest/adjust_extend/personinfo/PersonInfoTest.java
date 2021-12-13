/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.adjust_extend.personinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.huawei.refused_bequest.adjust_extend.personinfo.constant.Constant;
import com.huawei.refused_bequest.adjust_extend.personinfo.person.Adult;
import com.huawei.refused_bequest.adjust_extend.personinfo.person.Children;
import com.huawei.refused_bequest.adjust_extend.personinfo.person.Old;

/**
 * @filename: PersonInfoTest
 * @description: PersonInfo测试用例
 */
class PersonInfoTest {
    @Test
    void should_get_adult_info() {
        String info = "Name: LaoZhang" + Constant.LINE_SEPARATOR
                + "IsObese: false" + Constant.LINE_SEPARATOR
                + "MonthlyPensionWage: 3221";
        PersonInfo old = new Old("LaoZhang", 1.75, 65, 2000, 5);
        assertEquals(info, old.printInfo());
    }

    @Test
    void should_get_old_info() {
        String info = "Name: ZhangSan" + Constant.LINE_SEPARATOR
                + "CommutingTimeEveryWeek: 10" + Constant.LINE_SEPARATOR
                + "IsObese: true";
        PersonInfo adult = new Adult("ZhangSan", 1.80, 85, 2);
        assertEquals(info, adult.printInfo());
    }

    @Test
    void should_get_child_info() {
        String info = "Name: XiaoMing" + Constant.LINE_SEPARATOR
                + "IsObese: true" + Constant.LINE_SEPARATOR
                + "IsReachSchoolAge: false";
        PersonInfo children = new Children("XiaoMing", 5, 1.20, 42);
        assertEquals(info, children.printInfo());
    }

}