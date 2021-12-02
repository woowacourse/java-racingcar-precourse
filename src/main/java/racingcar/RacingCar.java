package racingcar;

import racingcar.car.Car;
import racingcar.car.CarRepository;
import racingcar.car.CarRepositoryService;
import racingcar.car.CarService;
import racingcar.exceptions.ProcessException;
import racingcar.view.CarListView;
import racingcar.view.ProcessView;
import racingcar.view.ResultView;
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
		printViews();

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
			return;
		}

		printProcessView();
	}

	private void printProcessView() {
		view = new ProcessView();
		printViews();

		getUserProcessInput();
	}

	private void getUserProcessInput() {
		String userProcess = view.getUserInput();
		try {
			ProcessException.processException(userProcess);

			accelerateCar(userProcess);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getUserProcessInput();
			return;
		}
	}

	private void accelerateCar(String userProcess) {
		view = new ResultView(carRepository);

		int process = Integer.parseInt(userProcess);
		for (int i = 0; i < process; i++) {
			moveCar();
		}
	}

	private void moveCar() {
		for (Car car : carRepository.getCars()) {
			CarService.accelerate(car);
		}
		printResultView();
	}

	private void printResultView() {
		printViews();
	}

	private void printViews() {
		view.printView();
	}
}
