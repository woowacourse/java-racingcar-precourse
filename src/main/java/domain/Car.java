/*
 * @(#)Car.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

public class Car implements Movable, Comparable<Car> {

    private final int id;
    private final String name;
    private int position = 0;

    Car(String name) {
        this.id = CarId.getInstance().increaseId();
        this.name = name;
    }

    Car(String name, int position) {
        this.id = CarId.getInstance().increaseId();
        this.name = name;
        this.position = position;
    }

    Car(int id, String name, int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public void go() {
        position += RacingGameConfig.STEP;
    }

    int getId() {
        return id;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if ((object == null) || object.getClass() != this.getClass()) {
            return false;
        }

        return this.name.equals(((Car) object).name) && (this.position == ((Car) object).position);
    }

    @Override
    public int compareTo(Car o) {
        if (o.position < this.position) {
            return 1;
        }

        if ((o.position == this.position) && (o.id < this.id)) {
            return 1;
        }
        if ((o.position == this.position) && (o.id == this.id)) {
            return 0;
        }

        return -1;
    }

    @Override
    public String toString() {
        return name;
    }
}
