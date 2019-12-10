package com.woowacourse.racingcar.domain;

import java.util.Objects;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-09
 */
public class Car {
    private static final String NAME_LENGTH_OUT_OF_RANGE_EXCEPTION = "이름의 길이는 1~5자리 문자로 구성되어야 합니다.";
    private static final String OUT_OF_RANGE_EXCEPTION = "힘의 범위를 벗어났습니다.";
    private static final String RACING_POSITION_INDICATOR = "-";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_POWER = 0;
    public static final int MAX_POWER = 9;
    private static final int MIN_FORWARD_POWER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_OUT_OF_RANGE_EXCEPTION);
        }
    }

    public void forward(int power) {
        validatePowerRange(power);
        if (canForward(power)) {
            ++position;
        }
    }

    private void validatePowerRange(int power) {
        if (power < MIN_POWER || power > MAX_POWER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }

    private boolean canForward(int power) {
        return power >= MIN_FORWARD_POWER;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String toPositionString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; ++i) {
            stringBuilder.append(RACING_POSITION_INDICATOR);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car)o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
