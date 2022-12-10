package racingcar.domain.repository;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.Map;

public class CarRepositoryImpl implements CarRepository{

    private static Map<String, Car> store = new HashMap<>();

    @Override
    public void save(Car car) {
        store.put(car.getName(), car);
    }

    @Override
    public Car findByName(String name) {
        return store.get(name);
    }
}
