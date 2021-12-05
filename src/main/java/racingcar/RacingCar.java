package racingcar;

import racingcar.car.Car;
import racingcar.car.CarRepository;
import racingcar.car.CarRepositoryService;
import racingcar.car.CarService;
import racingcar.exceptions.ExecutionException;
import racingcar.view.CarListView;
import racingcar.view.ExecutionView;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.View;
import racingcar.view.WinnerView;
import racingcar.winner.WinnerList;
import racingcar.winner.WinnerListService;

public class RacingCar {
	View view;
	InputView inputView;
	CarRepository carRepository;
	CarRepositoryService carRepositoryService;

	//초기 설정 및 자동차 입력받는 화면 출력
	public void racingCar() {
		view = new CarListView();
		inputView = new CarListView();
		carRepository = new CarRepository();

		printCarListView();
	}

	private void printCarListView() {
		printViews();

		getUserCarList();
	}

	private void getUserCarList() {
		String userCarList = inputView.getUserInput();
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

		printExecutionView();
	}

	//실행 횟수 입력화면 출력
	private void printExecutionView() {
		view = new ExecutionView();
		inputView = new ExecutionView();
		printViews();

		getUserExecutionTime();
	}

	private void getUserExecutionTime() {
		String userExecutionTime = inputView.getUserInput();
		try {
			ExecutionException.executionException(userExecutionTime);

			executeRace(userExecutionTime);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getUserExecutionTime();
			return;
		}
	}

	//횟수 만큼 경주 시작
	private void executeRace(String userProcess) {
		view = new ResultView(carRepository);
		int executionTime = Integer.parseInt(userProcess);
		for (int i = 0; i < executionTime; i++) {
			accelerateCar();
		}

		setWinner();
	}

	//자동차 전진 혹은 정지
	private void accelerateCar() {
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
