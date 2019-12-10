/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Car.java
 * 자동차 클래스
 *
 * @author		Sorin Jin
 * @version		1.0
 * @date		09 Dec 2019
 *
 */

package domain;

import controller.GameController;

public class Car {
    private final String name;
    private int position = 0;
    private int randomNumber;

    public Car(String name) {
        this.name = name;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void play() {
        if(isGoNumber()) {
            go();
        }
        print();
    }

    private boolean isGoNumber() {
        if((randomNumber >= GameController.GO_MIN_VALUE) && (randomNumber <= GameController.GO_MAX_VALUE)) {
            return true;
        }
        return false;
    }

    private void go() {
        position += randomNumber;
    }

    private void print() {
        System.out.print(name+":");
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
