package racingcar.repository;

import racingcar.Car;

public interface CarRepository {
	public void save(Car car);
	public Car findById(int carId);
}
