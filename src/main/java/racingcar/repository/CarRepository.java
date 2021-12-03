package racingcar.repository;

import java.util.Map;

import racingcar.Car;

public interface CarRepository {
	public void save(Car car);
	public Car findById(int carId);
	public Map<Integer, Car> findAll();
	public int findMaxPosition();
}
