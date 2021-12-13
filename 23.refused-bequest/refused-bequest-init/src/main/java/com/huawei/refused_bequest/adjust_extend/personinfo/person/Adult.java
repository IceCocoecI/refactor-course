/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.refused_bequest.adjust_extend.personinfo.person;

import com.huawei.refused_bequest.adjust_extend.personinfo.PersonInfo;
import com.huawei.refused_bequest.adjust_extend.personinfo.constant.Constant;

/**
 * @filename: Adult
 * @description: 成年人信息
 */
public class Adult extends PersonInfo {
    /**
     * 通勤时间
     */
    protected final int commutingTimeEveryDay;

    public Adult(String name, double height, double weight,
        int commutingTimeEveryDay) {
        super(name, height, weight);
        this.commutingTimeEveryDay = commutingTimeEveryDay;
    }

    @Override
    public String printInfo() {
        return "Name: " + name + Constant.LINE_SEPARATOR
            + "CommutingTimeEveryWeek: " + getCommutingTimeEveryWeek() + Constant.LINE_SEPARATOR
            + "IsObese: " + isObese(25.0);
    }

    private int getCommutingTimeEveryWeek() {
        return commutingTimeEveryDay * 5;
    }
}
