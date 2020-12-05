package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    final static int NAME_LENGTH_LIMIT = 5;
    final static int MAX_NUMBER_OF_CARS = 7;
    final static int MIN_NUMBER_OF_CARS = 2;

    private List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> carList) {
        validateSize(carList);
        validateNameLength(carList);
        makeRacingCarList(carList);
    }

    public List<Car> getRacingCars() {
        return cars;
    }

    private void validateSize(List<String> carList) throws IllegalArgumentException {
        if (carList.size() > MAX_NUMBER_OF_CARS || carList.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("[ERROR] 자동자 개수는 2-5개로 한정 된다.");
        }
    }

    private void validateNameLength(List<String> carList) throws IllegalArgumentException {
        for (int car = 0; car < carList.size(); car++) {
            if (carList.get(car).length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 한다.");
            }
        }
    }

    private void makeRacingCarList(List<String> carList) {
        for (int car = 0; car < carList.size(); car++) {
            Car racingCar = new Car(carList.get(car));
            cars.add(racingCar);
        }
    }
}
