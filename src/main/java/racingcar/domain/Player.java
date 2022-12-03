package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.NumberGenerator;

public class Player {

    private final List<Car> racingCars;

    public Player(List<String> playerNames) {
        this.racingCars = setRacingCars(playerNames);
    }

    private List<Car> setRacingCars(List<String> playerNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String name : playerNames) {
            Car car = new Car(name);
            racingCars.add(car);
        }
        return racingCars;
    }

    public void playOneRound(NumberGenerator numberGenerator) {
        for (Car car : racingCars) {
            car.moveOrStop(numberGenerator);
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
