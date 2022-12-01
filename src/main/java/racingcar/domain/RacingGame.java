package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

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

    public boolean canContinue(int currentTrial) {
        return currentTrial <= trial;
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }
}
