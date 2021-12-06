package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.Car;

public class RacingService {

	public static void playOneRound(List<Car> cars) {
		for (Car car : cars) {
			moveCar(car);
		}
		OutputService.getOneRoundRacingResult(cars);
	}

	public static void moveCar(Car car) {
		if (RandomService.isCarMovable()) {
			car.moveForward();
		}
	}

	public static int getMaxMovedPosition(List<Car> cars){
		int maxPosition = 0;
		for (Car car: cars){
			int position = car.getPosition();
			if (maxPosition < position){
				maxPosition = position;
			}
		}
		return maxPosition;
	}

	public static List<String> getWinner(List<Car> cars){
		int maxPosition = getMaxMovedPosition(cars);
		return cars.stream()
			.filter((car) -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
