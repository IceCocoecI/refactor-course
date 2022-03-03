/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.primitive_obsession;

import java.text.MessageFormat;
import java.util.List;
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

    public void fly(List<int[]> airLine, String airLineType) {
        for (int[] coordinate : airLine) {
            if (coordinate.length != 2) {
                throw new IllegalArgumentException("Air line is invalid.");
            }
            if ("domestic".equals(airLineType)) { // 国内航班
                if (coordinate[0] < 0 || coordinate[0] >= 100) {
                    throw new IllegalArgumentException("Air line is invalid.");
                }
                if (coordinate[1] < 0 || coordinate[1] >= 100) {
                    throw new IllegalArgumentException("Air line is invalid.");
                }
            }
            if ("international".equals(airLineType)) { // 国际航班
                if (coordinate[0] < 100) {
                    throw new IllegalArgumentException("Air line is invalid.");
                }
                if (coordinate[1] < 100) {
                    throw new IllegalArgumentException("Air line is invalid.");
                }
            }
        }
        airLine.forEach(this::fly);
    }

    private void fly(int[] coordinate) {
        logger.info(MessageFormat.format("Fly to ({0},{1})", coordinate[0], coordinate[1]));
    }
}
