package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.Car;

public class CarRepository {
	private Long id = 0L;
	private final Map<Long, Car> cars = new HashMap<>();

	public Long save(Car car) {
		cars.put(id, car);
		id += 1;
		return id;
	}

	public Car findById(Long id) {
		return cars.get(id);
	}

	public List<Car> findAll() {
		return new ArrayList<>(cars.values());
	}
}
