package com.huawei.primitive_obsession_refactor;

/**
 * 坐标位置
 *
 * @since 2021-11-15
 */
public class Coordinate {
    private final int[] coordinate;

    public Coordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    void validateLength() {
        if (getCoordinate().length != 2) {
            throw new IllegalArgumentException("Air line is invalid.");
        }
    }

    int getX() {
        return getCoordinate()[0];
    }

    int getY() {
        return getCoordinate()[1];
    }
}
