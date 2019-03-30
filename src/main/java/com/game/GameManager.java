package com.game;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Car> cars = new ArrayList<>();

    public GameManager(String[] names) {
        for (String i : names) {
            cars.add(new Car(i));
        }
    }

    public void moveCars() {
        for (Car i : cars) {
            i.move();
        }
    }
}
