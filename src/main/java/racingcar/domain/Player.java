package racingcar.domain;

import racingcar.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private final int numberOfAttempts;
    private final List<Car> cars;

    public Player(String[] carNames, int numberOfAttempts) {
        this.cars = initCarList(carNames);
        this.numberOfAttempts = numberOfAttempts;
    }

    private List<Car> initCarList(String[] carNames) {
        List<Car> newList = new ArrayList<>();
        for (String carName : carNames) {
            newList.add(new Car(carName));
        }
        return newList;
    }
}
