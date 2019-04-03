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
        for (Car car : cars) {
            car.move();
        }
    }

    public void boardPrint() {
        for (Car car : cars) {
            System.out.print(car.getName() + ": ");
            for (int i = 0; i < car.getPosition(); ++i) {
                System.out.print('-');
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<String> getWinnerNames() {
        List<String> winner = new ArrayList<>();
        int winnerPosition = 0;
        for (Car car : cars) {
            if (winnerPosition < car.getPosition()) {
                winner.clear();
                winner.add(car.getName());
                winnerPosition = car.getPosition();
            } else if (winnerPosition == car.getPosition()) {
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
