package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String cars) {
        transferCarsType(Arrays.asList(cars.split(",")));
    }

    private void transferCarsType(List<String> cars) {
        this.cars = cars.stream().map(car -> new Car(car)).collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.move());
    }

    public List<Car> cars() {
        return cars;
    }
}
