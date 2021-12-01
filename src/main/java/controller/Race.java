package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.CarDto;
import domain.Cars;
import domain.MoveCount;
import domain.Names;
import view.InputView;
import view.OutputView;

public class Race {
	public void startRace() {
		Names names = InputView.inputCarNames();
		Cars cars = new Cars(names);
		MoveCount moveCount = InputView.inputMoveCount();

		for (int i = 0; i < moveCount.toInt(); i++) {
			moveCars(cars);
			printCars(cars);
		}
	}

	public void moveCars(Cars cars) {
		cars.moveAll();
	}

	public void printCars(Cars cars) {
		List<CarDto> carDtos = cars.getCars().stream()
			.map(CarDto::from)
			.collect(Collectors.toList());

		OutputView.printCars(carDtos);
	}

}
