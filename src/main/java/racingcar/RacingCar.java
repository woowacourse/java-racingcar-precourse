package racingcar;

import java.util.ArrayList;
import java.util.Collections;

import racingcar.car.Car;
import racingcar.car.CarRepository;
import racingcar.car.CarRepositoryService;
import racingcar.view.CarListView;
import racingcar.view.View;

public class RacingCar {
	View view;
	CarRepository carRepository;
	CarRepositoryService carRepositoryService;

	public void racingCar() {
		view = new CarListView();
		carRepository = new CarRepository();

		printCarList();
	}

	private void printCarList() {
		view.printView();

		getUserCarList();
	}

	private void getUserCarList() {
		String userCarList = view.getUserInput();
		carRepositoryService = new CarRepositoryService(carRepository);

		saveCars(userCarList);
	}

	private void saveCars(String userCarList) {
		try {
			carRepositoryService.checkException(userCarList);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			printCarList();
		}
	}
}
