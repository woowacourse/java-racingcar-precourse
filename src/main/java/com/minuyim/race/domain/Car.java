package com.minuyim.race.domain;

import com.minuyim.race.utils.Constants;
import com.minuyim.race.utils.RandomGenerator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void moveFoward() {
        if (RandomGenerator.generateRandom() >= Constants.MOVE_CONDITION_NUMBER) {
            this.position++;
        }
    }
}