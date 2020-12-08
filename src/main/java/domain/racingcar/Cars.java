package domain.racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.RandomUtils.LOWER_BOUNDARY;
import static utils.RandomUtils.UPPER_BOUNDARY;

/**
 * 자동차들을 List로 가지고 있으면서 필요한 함수를 수행하는 객체
 *
 * @author 조연우
 * @version 1.0 2020년 12월 8일
 */
public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> names) {
        for (String carName : names) {
            makeNewCarByName(carName);
        }
    }

    private void makeNewCarByName(final String carName) {
        this.cars.add(CarFactory.createCar(carName));
    }

    public void playUnitGame() {
        for (Car car : this.cars) {
            car.movePosition(RandomUtils.nextInt(LOWER_BOUNDARY, UPPER_BOUNDARY));
        }
    }

    public final List<List<String>> makeUnitResult() {
        return this.cars.stream().map(Car::getNameAndPosition).collect(Collectors.toList());
    }

    public final List<String> generateWinners() {
        Winner winner = new Winner(this.cars);
        return winner.makeWinnersName();
    }
}
