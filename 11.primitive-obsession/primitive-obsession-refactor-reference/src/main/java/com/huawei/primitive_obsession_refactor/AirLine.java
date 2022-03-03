/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.primitive_obsession_refactor;

import java.util.List;

/**
 * 航线接口
 *
 * @since 2021-11-15
 */
public interface AirLine {
    String DOMESTIC = "domestic";
    String INTERNATIONAL = "international";

    String getAirLineType();

    List<Coordinate> getCoordinates();

    void validate();
}
