/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.lazy_element_init.houseinfo;

import com.huawei.lazy_element_init.houseinfo.housedata.HouseData;

/**
 * 大户型
 *
 * @since 2021-11-08
 */
public class BigHouse extends House {
    private static final int BIG_HOUSE_AREA = 140;

    public BigHouse(HouseData houseData) {
        super(houseData);
    }

    /**
     * 是否是大户型
     * 
     * @return 是否是大户型
     */
    public boolean isBigHouse() {
        return houseData.getSquare() > BIG_HOUSE_AREA;
    }
}
