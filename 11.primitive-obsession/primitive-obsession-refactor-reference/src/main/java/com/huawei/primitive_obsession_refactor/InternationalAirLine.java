/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.primitive_obsession_refactor;

import java.util.List;

/**
 * 国际航班
 *
 * @since 2021-11-15
 */
public class InternationalAirLine extends AbstractAirLine {
    public InternationalAirLine(List<Coordinate> coordinates) {
        super(INTERNATIONAL, coordinates);
    }

    @Override
    protected void validateCoordinate(Coordinate coordinate) {
        if (coordinate.getX() < 100) {
            throw new IllegalArgumentException("Air line is invalid.");
        }
        if (coordinate.getY() < 100) {
            throw new IllegalArgumentException("Air line is invalid.");
        }
    }
}
