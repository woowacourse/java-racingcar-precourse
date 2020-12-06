package domain.racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.RandomUtils.LOWER_BOUNDARY;
import static utils.RandomUtils.UPPER_BOUNDARY;

/**
 * 이름들로 자동차들을 생성해 리스트로 가지고 있으며 함수를 수행하는 객체
 *
 * @author 조연우
 * @version 1.0 2020년 12월 3일
 */
public class CarFactory {
    private final List<Car> cars = new ArrayList<>();

    public CarFactory(List<String> carNames) {
        for (String carName : carNames) {
            makeNewCar(carName);
        }
    }

    private void makeNewCar(String carName) {
        this.cars.add(new Car(carName));
    }

    public void giveRandomNumbers() {
        for (Car car : this.cars) {
            car.increasePosition(RandomUtils.nextInt(LOWER_BOUNDARY, UPPER_BOUNDARY));
        }
    }

    public List<List<String>> makeCarsResult() {
        return this.cars.stream().map(Car::getNamePosition).collect(Collectors.toList());
    }

    public List<String> makeWinners() {
        return Winner.makeWinnersName(this.cars);
    }
}
