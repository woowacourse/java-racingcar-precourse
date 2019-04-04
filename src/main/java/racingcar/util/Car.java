/*
 * Car.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.util;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void runRandomly() {
        int randomNumber = RandomGenerator.getRandomNumber();
        if (randomNumber >= Constants.NUMBER_FORWARD_BOUND) {
            position++;
        }
    }

    /* only for testing */
    public void runByInput(int finalPos) {
        position = finalPos;
    }

    public void visualizePosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPos() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Car anotherCar) {
        return Integer.compare(position, anotherCar.getPos());
    }
}
