package racingcar.car;

import racingcar.car.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    private static class InnerInstanceClazz {
        private static final CarRepository instance = new CarRepository();
    }

    public static CarRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void createCar(Car car) {
        cars.add(car);
    }

    public int getCarCount() {
        return cars.size();
    }

    public void moveForward(int index) {
        cars.get(index).moveForward();
    }

    public List<CarDto> getCars() {
        return cars.stream()
                .map(Car::getCarDto)
                .collect(Collectors.toList());
    }
}