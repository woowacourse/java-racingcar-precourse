package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final int trial;

    public RacingGame(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public void run() {
        cars.stream()
                .filter(car -> car.canMove(getRandomNumber()))
                .forEach(Car::move);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
