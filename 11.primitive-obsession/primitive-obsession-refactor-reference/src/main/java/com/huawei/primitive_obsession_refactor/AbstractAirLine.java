package com.huawei.primitive_obsession_refactor;

import java.util.List;

/**
 * 航线抽象类
 *
 * @since 2021-11-15
 */
public abstract class AbstractAirLine implements AirLine {

    private final String airLineType;

    private final List<Coordinate> coordinates;

    AbstractAirLine(String airLineType, List<Coordinate> coordinates) {
        this.airLineType = airLineType;
        this.coordinates = coordinates;
    }

    @Override
    public String getAirLineType() {
        return airLineType;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    @Override
    public void validate() {
        for (Coordinate coordinate : getCoordinates()) {
            coordinate.validateLength();
            validateCoordinate(coordinate);
        }
    }

    protected abstract void validateCoordinate(Coordinate coordinate);
}
