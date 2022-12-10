package racingcar.domain.repository;

import racingcar.domain.Car;

public interface CarRepository {

    void save(Car car);
    Car findByName(String name);
}
