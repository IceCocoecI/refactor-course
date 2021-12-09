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
public class House {
    /**
     * 房屋信息数据
     */
    protected final HouseData houseData;

    public House(HouseData houseData) {
        this.houseData = houseData;
    }

    /**
     * 获取房屋面积
     *
     * @return 房屋面积
     */
    public double getSquare() {
        return houseData.getSquare();
    }

    /**
     * 获取房屋单价
     *
     * @return 单价
     */
    public double getUnitPrice() {
        return houseData.getUnitPrice();
    }
}
