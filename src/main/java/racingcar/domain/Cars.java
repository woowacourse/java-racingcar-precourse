package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String CARS_NAME_DELIMITER = ",";

    private List<Car> cars;

    public Cars(String cars) {
        transferCarsType(Arrays.asList(cars.split(CARS_NAME_DELIMITER)));
    }

    private void transferCarsType(List<String> cars) {
        this.cars = cars.stream()
            .map(car -> new Car(car))
            .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.move(new RandomMoveStrategy()));
    }

    public List<Car> cars() {
        return cars;
    }

    public List<CarDto> carsDto() {
        return cars.stream()
            .map(car -> CarDto.form(car))
            .collect(Collectors.toList());
    }
}
