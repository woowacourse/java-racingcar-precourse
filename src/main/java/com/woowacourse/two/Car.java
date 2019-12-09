package com.woowacourse.two;

public class Car {
    private final String name;
    private int position = 0;
    private String carDistance = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public String getCarDistance(){
        return this.carDistance;
    }

    public void movePosition(){
        this.position++;
        this.carDistance += "-";
    }

    // 추가 기능 구현
}
