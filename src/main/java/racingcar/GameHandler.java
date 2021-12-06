package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.constants.Message;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.UserInputService;
import racingcar.utils.Viewer;

public class GameHandler {
	private final UserInputService userInputService = UserInputService.getInstance();
	private final CarService carService = CarService.getInstance();

	public void run() {
		List<Car> cars = carService.createCars();
		int times = userInputService.howManyTimes();
		executeResult(times, cars);
		showWinners(cars);
	}

	private void executeResult(int times, List<Car> cars) {
		System.out.println(Message.EXECUTE_RESULT);

		while (times-- > 0) {
			executeStage(cars);
		}
	}

	private void executeStage(List<Car> cars) {
		carService.moveAllCars(cars);
		Viewer.showEachStageResult(cars);
	}

	private void showWinners(List<Car> cars) {
		List<Car> winnerCars = findWinnerCars(cars);

		Viewer.showWinnerCars(winnerCars);
	}

	private List<Car> findWinnerCars(List<Car> cars) {
		List<Car> winners = new ArrayList<>();

		int maxPositionValue = maxCurrentPosition(cars);
		for (Car car : cars) {
			if (car.currentPosition() == maxPositionValue) {
				winners.add(car);
			}
		}

		return winners;
	}

	private int maxCurrentPosition(List<Car> cars) {
		return cars.stream()
				.mapToInt(Car::currentPosition)
				.max().orElseThrow(IllegalArgumentException::new);
	}
}
