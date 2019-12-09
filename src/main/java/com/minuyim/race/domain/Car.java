package com.minuyim.race.domain;

import com.minuyim.race.utils.MessageStrings;
import com.minuyim.race.utils.RandomGenerator;

public class Car {
    private static final int MOVE_CONDITION_NUMBER = 4;
    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }
    
    String getName() {
        return this.name;
    }
    
    int getPosition() {
        return this.position;
    }
    
    boolean isPosition(int position) {
        return this.position == position;
    }
    
    private boolean isFoward() {
        return RandomGenerator.generateRandom() >= MOVE_CONDITION_NUMBER;
    }
    
    void moveFoward() {
        if (isFoward()) {
            this.position++;
        }
    }

    void printPosition() {
        
        // 공백을 this.position 숫자만큼 REFEATED_CHAR 문자로 치환
        String repeatChar = new String(new char[this.position])
                .replace("\0", MessageStrings.REFEATED_CHAR);
        System.out.println(String.format("%s : %s", this.name, repeatChar));
    }
}
