import java.util.*;

public class RacingCars {
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateNames(cars);
        this.cars = cars;
    }

    private void validateNames(List<Car> cars) {
        for (Car car : cars) {
            validateName(car);
        }
    }

    private void validateName(Car car) {
        if (car.nameLongerThan(MAX_LENGTH_OF_CAR_NAME)) {
            throw new IllegalArgumentException("각 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printWinners() {
        List<String> winners = getWinners();
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
