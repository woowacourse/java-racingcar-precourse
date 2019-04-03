package com.nekisse.domain;

public class CarName {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    private final String carName;

    private CarName(String carName) {
        if (!validFiveLength(carName)) {
            throw new IllegalArgumentException("자동차의 이름은 5자리 이하입니다.");
        }
        this.carName = carName;
    }

    private boolean validFiveLength(String carName) {
        return carName.trim().length() <= MAXIMUM_NAME_LENGTH;
    }

    public static CarName newCarName(String carName) {
        return new CarName(carName);
    }

    public String getCarName() {
        return carName;
    }
}
