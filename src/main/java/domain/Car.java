package domain;

import java.util.Random;

public class Car implements Movable, Comparable<Car> {
    //todo: apply annotation
    private int id;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public Car(int id, String name) {
        this(name);
        this.id = id;

    }
    public Car(int id, String name, int position) {
        this(id, name);
        this.position = position;
    }
    @Override
    public void go() {
        position += RacingGameConfig.STEP;
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

        return this.name.equals(((Car)object).name) && (this.position == ((Car)object).position);
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
