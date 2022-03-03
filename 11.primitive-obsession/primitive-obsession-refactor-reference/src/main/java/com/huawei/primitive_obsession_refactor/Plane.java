/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.primitive_obsession_refactor;

import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 * 飞机航线
 *
 * @since 2021-11-15
 */
public class Plane {
    private final Logger logger;

    public Plane(Logger logger) {
        this.logger = logger;
    }

    public void fly(AirLine airLine) {
        airLine.validate();
        airLine.getCoordinates().forEach(this::fly);
    }

    private void fly(Coordinate coordinate) {
        logger.info(MessageFormat.format("Fly to ({0},{1})", coordinate.getX(), coordinate.getY()));
    }
}
