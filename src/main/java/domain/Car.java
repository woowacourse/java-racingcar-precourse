/*
 * Car.java
 *
 * 1.8
 *
 * 2019/12/07
 *
 * Copyright (c) 2019 Janghee Lee
 * All rights reserved.
 * */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void go(){
        position++;
    }
}
