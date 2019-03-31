package com.conatuseus.racingcar.model;

import java.util.Random;

public class Car {
    private static final int MAX_RANDOM=9;
    private static final int MIN_RANDOM=0;
    private static final int CAN_GOING=4;

    private final String name;
    private int position = 0;
    private int random;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    private void setRandom(){
        this.random=(int)(Math.random()*MAX_RANDOM) + MIN_RANDOM;
    }

    public int getRandom(){
        return this.random;
    }

    private boolean isGoing(){
        return this.random >= CAN_GOING;
    }



}
