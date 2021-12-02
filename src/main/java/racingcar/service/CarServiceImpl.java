package racingcar.service;

import racingcar.Car;
import racingcar.repository.MemoryCarRepository;

public class CarServiceImpl implements CarService {

	private static final MemoryCarRepository memoryCarRepository = new MemoryCarRepository();

	@Override
	public void join(String name) {
		memoryCarRepository.save(new Car(name));
	}
}
