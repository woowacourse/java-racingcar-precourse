/*
 * Car Class
 *
 * @version 1
 *
 * @date 2019-04-02
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved
 */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int distance) {
        position += distance;
    }
}
