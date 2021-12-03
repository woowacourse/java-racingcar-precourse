package racingcar.repository;

import java.util.HashMap;
import java.util.Map;

import racingcar.Car;

public class MemoryCarRepository implements CarRepository {
	private static Map<Integer, Car> cars = new HashMap<>();

	@Override
	public void save(Car car) {
		cars.put(cars.size(), car);
	}

	@Override
	public Car findById(int carId) {
		return cars.get(carId);
	}

	@Override
	public Map<Integer, Car> findAll() {
		return cars;
	}

	@Override
	public int findMaxPosition() {
		int maxPosition = 0;
		for (int carId : cars.keySet()) {
			maxPosition = Math.max(findById(carId).getPosition(), maxPosition);
		}
		return maxPosition;
	}
}
