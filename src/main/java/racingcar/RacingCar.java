package racingcar;

import racingcar.car.CarRepository;
import racingcar.car.CarRepositoryService;
import racingcar.exceptions.ProcessException;
import racingcar.process.Process;
import racingcar.view.CarListView;
import racingcar.view.ProcessView;
import racingcar.view.View;

public class RacingCar {
	View view;
	CarRepository carRepository;
	CarRepositoryService carRepositoryService;

	public void racingCar() {
		view = new CarListView();
		carRepository = new CarRepository();

		printCarListView();
	}

	private void printCarListView() {
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
			getUserCarList();
		}

		printProcessView();
	}

	private void printProcessView() {
		view = new ProcessView();
		view.printView();

		getUserProcessInput();
	}

	private void getUserProcessInput() {
		String userProcess = view.getUserInput();

		try {
			ProcessException.processException(userProcess);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getUserProcessInput();
		}
	}
}
