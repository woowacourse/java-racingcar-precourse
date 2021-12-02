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
import racingcar.view.WinnerView;
import racingcar.winner.WinnerList;
import racingcar.winner.WinnerListService;

public class RacingCar {
	View view;
	CarRepository carRepository;
	CarRepositoryService carRepositoryService;

	//초기 설정 및 자동차 입력받는 화면 출력
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

	//실행 횟수 입력화면 출력
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

	//횟수 만큼 경주 시작
	private void accelerateCar(String userProcess) {
		view = new ResultView(carRepository);
		int process = Integer.parseInt(userProcess);
		for (int i = 0; i < process; i++) {
			moveCar();
		}

		setWinner();
	}

	//자동차 전진 혹은 정지
	private void moveCar() {
		for (Car car : carRepository.getCars()) {
			CarService.accelerate(car);
		}
		printResultView();
	}

	private void printResultView() {
		printViews();
	}

	private void setWinner() {
		WinnerList winnerList = new WinnerListService(carRepository).setWinner();

		printWinnerView(winnerList);
	}

	private void printWinnerView(WinnerList winnerList) {
		view = new WinnerView(winnerList);
		printViews();
	}

	private void printViews() {
		view.printView();
	}
}
