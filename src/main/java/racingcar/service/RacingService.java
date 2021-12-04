package racingcar.service;

import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingService {

	private static final CarRepository carRepository = new CarRepository();

	private static final int MIN_RANDOM_VALUE = 0;
	private static final int MAX_RANDOM_VALUE = 9;

	public void registerCars(String[] carNames) {
		Stream.of(carNames)
			.forEach(n -> carRepository.save(new Car(n)));
	}

	public void race() {
		carRepository.findAll()
			.stream()
			.forEach(car -> car.action(getRandomValue()));
	}

	private int getRandomValue() {
		return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
	}
}
