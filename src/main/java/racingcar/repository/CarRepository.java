package racingcar.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.domain.Car;

public class CarRepository {

	private static final List<Car> carRepository = new ArrayList<>();

	public void save(Car car) {
		carRepository.add(car);
	}

	public List<Car> findAll() {
		return carRepository;
	}

	public void sortByPosition() {
		Collections.sort(carRepository);
	}

	public int findFirstCarPosition() {
		return carRepository.get(0).getPosition();
	}
}
