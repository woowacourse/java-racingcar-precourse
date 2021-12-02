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
}
