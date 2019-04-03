package domain;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }


    public int positionIs() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    @Override
    public int compareTo(Car o) {
        if(o.position > this.position) {
            return 1;
        }
        if(o.position == this.position) {
            return 0;
        }

        return -1;
    }


    @Override
    public String toString() {
        return this.name;
    }


}
