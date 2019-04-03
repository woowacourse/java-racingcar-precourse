package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goForward() {
        int go = (int) (Math.random() * 9);
        if (go >= 4) {
            position += go;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarsName(){
        return name;
    }

}
