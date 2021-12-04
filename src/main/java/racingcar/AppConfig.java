package racingcar;

import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;

public class AppConfig {

	public CarService carService() {
		return new CarServiceImpl(carRepository());
	}

	private CarRepository carRepository() {
		return new MemoryCarRepository();
	}
}
