package com.woowa.racingcar;

import java.util.Random;

public class Computer {
    private static final int RANDOM_MAX = 10;

    private Car[] carList;

    Computer() {}

    public void setCarList(String carName) {
        String[] carNameList = carName.split(",");
        carList = new Car[carNameList.length];
        
        for(int i = 0; i < carNameList.length; i++) {
            carList[i] = new Car(carNameList[i]);
        }
    }

    public int makeRandom() {
        Random r = new Random();
        return r.nextInt(RANDOM_MAX);
    }
}