package com.woowa.racingcar;

public class Computer {
    private Car[] carList;

    Computer() {}

    public void setCarList(String carName) {
        String[] carNameList = carName.split(",");
        carList = new Car[carNameList.length];
        
        for(int i = 0; i < carNameList.length; i++) {
            carList[i] = new Car(carNameList[i]);
        }
    }
}