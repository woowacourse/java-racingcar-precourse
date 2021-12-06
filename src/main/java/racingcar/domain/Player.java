package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.Car;

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

    public List<Car> getCars() {
        return cars;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
