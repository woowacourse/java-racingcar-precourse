package racingcar.service;

import racingcar.constants.Message;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
	private static CarService instance = new CarService();
	private final UserInputService userInputService = UserInputService.getInstance();

	private CarService() {
	}

	public static CarService getInstance() {
		if (instance == null) {
			instance = new CarService();
		}
		return instance;
	}

	public List<Car> createCars() {
		System.out.println(Message.START);

		List<Car> garage = new ArrayList<>();
		String[] carNames = userInputService.register();

		for (String carName : carNames) {
			garage.add(new Car(carName));
		}

		return garage;
	}

	public void moveAllCars(List<Car> cars) {
		for (Car car : cars) {
			car.go();
		}
	}
}
