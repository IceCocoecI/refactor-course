/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.primitive_obsession_refactor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Plane测试类
 *
 * @since 2021-11-15
 */
class PlaneTest {
    private final Logger logger = Mockito.mock(Logger.class);

    private final Plane plane = new Plane(logger);

    @DisplayName("给定一条坐标小于0的国内航线，当调用飞机飞行时，抛异常")
    @Test
    void given_domestic_air_line_with_coordinate_less_than_zero_when_fly_then_throw_exception() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                final List<int[]> airLine = Collections.singletonList(new int[] {-1, -1});
                plane.fly(AirLineFactory.createAbstractAirLine("domestic", toCoordinates(airLine)));
            });
    }

    private List<Coordinate> toCoordinates(List<int[]> airLine) {
        return airLine.stream().map(Coordinate::new).collect(Collectors.toList());
    }

    @DisplayName("给定一条坐标大于100的国内航线，当调用飞机飞行时，抛异常")
    @Test
    void given_domestic_air_line_with_coordinate_grater_than_100_when_fly_then_throw_exception() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                final List<int[]> airLine = Collections.singletonList(new int[] {101, 100});
                plane.fly(AirLineFactory.createAbstractAirLine("domestic", toCoordinates(airLine)));
            });
    }

    @DisplayName("给定一条坐标小于100的国际航线，当调用飞机飞行时，抛异常")
    @Test
    void given_international_air_line_with_coordinate_less_than_100_when_fly_then_throw_exception() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                final List<int[]> airLine = Collections.singletonList(new int[] {99, 99});
                plane.fly(AirLineFactory.createAbstractAirLine("international", toCoordinates(airLine)));
            });
    }

    @DisplayName("给定一条带2个坐标的国内航线，当调用飞机飞行时，会沿航线飞行")
    @Test
    void given_domestic_air_line_with_2_coordinate_when_fly_then_fly_with_coordinate() {
        final List<int[]> airLine = Arrays.asList(new int[] {2, 2}, new int[] {3, 4});
        plane.fly(AirLineFactory.createAbstractAirLine("domestic", toCoordinates(airLine)));
        Mockito.verify(logger, Mockito.times(1)).info("Fly to (2,2)");
        Mockito.verify(logger, Mockito.times(1)).info("Fly to (3,4)");
    }

    @DisplayName("给定一条带3个坐标的国际航线，当调用飞机飞行时，会沿航线飞行")
    @Test
    void given_international_air_line_with_3_coordinate_when_fly_then_fly_with_coordinate() {
        final List<int[]> airLine = Arrays.asList(new int[] {101, 101}, new int[] {103, 104});
        plane.fly(AirLineFactory.createAbstractAirLine("international", toCoordinates(airLine)));
        Mockito.verify(logger, Mockito.times(1)).info("Fly to (101,101)");
        Mockito.verify(logger, Mockito.times(1)).info("Fly to (103,104)");
    }
}