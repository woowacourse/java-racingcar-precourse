package racingcar.service;

import java.util.stream.Stream;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingService {

	private static final CarRepository carRepository = new CarRepository();

	public void registerCars(String[] carNames) {
		Stream.of(carNames)
			.forEach(n -> carRepository.save(new Car(n)));
	}
}
