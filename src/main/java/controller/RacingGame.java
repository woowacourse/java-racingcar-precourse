package controller;

import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;
	private static final int LEAST_PROGRESS_NUMBER = 4;

	private Cars cars;
	private int trial;
	private InputView inputView;

	public RacingGame() {
		this.inputView = new InputView();
		this.cars = new Cars(this.inputView.getCarNames());
		this.trial = this.inputView.getTrialNumber();
	}

	public void start() {
		OutputView.printExecutionResultMessage();
		for (int i = 0; i < this.trial; i++) {
			turn();
			OutputView.printProgress(this.cars);
		}
	}

	public void end() {
		OutputView.printWinners(getWinners());
	}

	private void turn() {
		for (Car car : this.cars.getCars()) {
			if (getRandomNumber() >= LEAST_PROGRESS_NUMBER) {
				car.progress();
			}
		}
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}

	private List<String> getWinners() {
		List<String> winners = new ArrayList<>();
		int maxPosition = cars.getMaxPosition();
		for (Car car : cars.getCars()) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}
}
