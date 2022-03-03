/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.primitive_obsession_refactor;

import java.util.List;

/**
 * 航线工厂类
 *
 * @since 2021-11-15
 */
public class AirLineFactory {
    public static AbstractAirLine createAbstractAirLine(String airLineType, List<Coordinate> coordinates) {
        if(AirLine.DOMESTIC.equals(airLineType)){
            return new DomesticAirLine(coordinates);
        }
        if(AirLine.INTERNATIONAL.equals(airLineType)){
            return new InternationalAirLine(coordinates);
        }
        return null;
    }
}
