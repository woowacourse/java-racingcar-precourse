package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    final static int NAME_LENGTH_LIMIT = 5;
    final static int MAX_NUMBER_OF_CARS = 7;
    final static int MIN_NUMBER_OF_CARS = 2;

    private final List<Car> cars = new ArrayList<>();
    private int maxPosition = 0;

    public RacingCars(List<String> carList) {
        validateSize(carList);
        validateNameLength(carList);
        validateDuplicatedName(carList);
        makeRacingCarList(carList);
    }

    public int getTotalNumberOfCars () {
        return cars.size();
    }

    public Car getCar(int carIndex) {
        return cars.get(carIndex);
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    private void validateSize(List<String> carList) throws IllegalArgumentException {
        if (carList.size() > MAX_NUMBER_OF_CARS || carList.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("[ERROR] 자동자 개수는 2-7개로 한정 됩니다.");
        }
    }

    private void validateNameLength(List<String> carList) throws IllegalArgumentException {
        for (int car = 0; car < carList.size(); car++) {
            if (carList.get(car).length() >  NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private void validateDuplicatedName(List<String> carList) throws IllegalArgumentException {
        boolean duplicated = carList.stream()
                .distinct()
                .count() != carList.size();

        if (duplicated) {
            throw new IllegalArgumentException("[ERROR] 동일한 자동차 이름을 입력할 수 없습니다.");
        }
    }

    private void makeRacingCarList(List<String> carList) {
        for (int car = 0; car < carList.size(); car++) {
            Car racingCar = new Car(carList.get(car));
            cars.add(racingCar);
        }
    }

    public void takeOneRound() {
        for (int car = 0; car < cars.size(); car++) {
            cars.get(car).runRace();
            updateMaxPosition(cars.get(car));
        }
    }

    private void updateMaxPosition(Car car) {
        if (maxPosition < car.getPosition()) {
            maxPosition = car.getPosition();
        }
    }
}
