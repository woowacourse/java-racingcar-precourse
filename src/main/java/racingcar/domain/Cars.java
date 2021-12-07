package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(toList());
        return new Cars(cars);
    }

    public void playRound() {
        for (Car car : cars) {
            car.moveOrStay(Randoms.pickNumberInRange(0, 9));
        }
    }

    public String getWinner() {
        int winnerPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.isMaxPosition(winnerPosition))
                .map(Car::getName)
                .collect(joining(", "));
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}