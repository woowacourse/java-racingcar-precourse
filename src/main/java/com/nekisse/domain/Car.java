package com.nekisse.domain;

public class Car {
    private final CarName carName;
    private int position = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return String.valueOf(carName.getCarName());
    }

    public int getPosition() {
        return position;
    }


    // 추가 기능 구현



}
