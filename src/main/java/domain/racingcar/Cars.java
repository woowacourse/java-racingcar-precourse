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
 * @version 1.0 2020년 12월 7일
 */
public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> names) {
        for (String carName : names) {
            makeNewCar(carName);
        }
    }

    private void makeNewCar(final String carName) {
        this.cars.add(CarFactory.createCar(carName));
    }

    public void playUnitGame() {
        for (Car car : this.cars) {
            car.increasePosition(RandomUtils.nextInt(LOWER_BOUNDARY, UPPER_BOUNDARY));
        }
    }

    public final List<List<String>> makeCarsResult() {
        return this.cars.stream().map(Car::getNamePosition).collect(Collectors.toList());
    }

    public final List<String> makeWinners() {
        return Winner.makeWinnersName(this.cars);
    }
}
