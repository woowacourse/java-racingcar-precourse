package domain;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.utils.InputUtils;
import domain.utils.OutputUtils;

public class Main {
	public static void main(String[] args) {
		List<String> carNames = InputUtils.getNames();
		Integer numberToRun = InputUtils.getRuns();
		List<Car> carList = makeCars(carNames);

		System.out.printf("\n실행 결과\n");
		for (int i = 0; i < numberToRun; i++) {
			runCars(carList);
			carList.stream().forEach(OutputUtils::printCarProgress);
			System.out.println();
		}

		List<String> winners = findWinners(carList);
		OutputUtils.printWinner(winners);
		InputUtils.inputClose();
	}

	static List<Car> makeCars(List<String> carNames) {
		return carNames.stream()
			.map(name -> new Car(name))
			.collect(Collectors.toList());
	}

	static void runCars(List<Car> carList) {
		Random random = new Random();
		carList.stream().forEach(car -> car.run(random.nextInt(10)));
	}

	static List<String> findWinners(List<Car> carList) {
		Integer maxPosition = carList.stream()
			.max(Comparator.comparingInt(Car::getPosition))
			.get()
			.getPosition();
		return carList.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
