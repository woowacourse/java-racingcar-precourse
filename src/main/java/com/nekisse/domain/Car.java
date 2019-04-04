package com.nekisse.domain;

public class Car {

    public static final int MOVEABLE_NUMBER = 3;
    private final CarName carName;
    private int position = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public int compareToMovePosition(int position) {
        return this.position > position ? this.position : position;
    }

    public String getCarName() {
        return String.valueOf(carName.getCarName());
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int highScore) {
        return this.position == highScore;
    }

    public void move(int generateRandomNumber) {
        if (generateRandomNumber > MOVEABLE_NUMBER) {
            position++;
        }
    }


    // 추가 기능 구현



}
