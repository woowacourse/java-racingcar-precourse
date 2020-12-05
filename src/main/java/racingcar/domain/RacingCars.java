package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.view.InputView;

public final class RacingCars {

    private final List<Car> racingCars;

    public RacingCars(final String carNames) {
        this.racingCars = setUpCars(carNames);
    }

    public RacingCars(final List<Car> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public List<Car> setUpCars(final String carNames) {
        final List<Car> racingCars = Arrays.stream(carNames.split(InputView.DELIMITER))
                .map(carName -> new Car(carName.trim()))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(racingCars);
    }

    public RacingCars moveCars() {
        final List<Car> cars = new ArrayList<>();

        for (Car racingCar : racingCars) {
            cars.add(racingCar.move());
        }

        return new RacingCars(cars);
    }

    public List<String> findWinners() {
        final Map<Integer, List<String>> scoreBoard = new HashMap<>();

        for (Car racingCar : racingCars) {
            final List<String> names =
                    scoreBoard.computeIfAbsent(racingCar.getPosition(), ArrayList::new);
            names.add(racingCar.getName());
        }

        final int maxPosition = Collections.max(scoreBoard.keySet());

        return scoreBoard.get(maxPosition);
    }
}
