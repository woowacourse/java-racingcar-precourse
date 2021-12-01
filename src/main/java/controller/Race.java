package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.CarDto;
import domain.Cars;
import domain.MoveCount;
import domain.Names;
import domain.Winners;
import domain.WinnersDto;
import view.InputView;
import view.OutputView;

public class Race {
	public void startRace() {
		Names names = InputView.inputCarNames();
		Cars cars = Cars.from(names);
		MoveCount moveCount = InputView.inputMoveCount();

		OutputView.printResultMessage();
		for (int i = 0; i < moveCount.toInt(); i++) {
			moveCars(cars);
			printCars(cars);
		}

		printWinners(cars);
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

	public void printWinners(Cars cars) {
		Winners winners = cars.getWinners();
		OutputView.printWinners(WinnersDto.from(winners));
	}

}
