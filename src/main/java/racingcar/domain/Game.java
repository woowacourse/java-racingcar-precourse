package racingcar.domain;

import java.util.ArrayList;

import racingcar.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

	private ArrayList<Car> carsList = new ArrayList<Car>();
	private int gameCount = 0;
	private int maxPosition = 0;
	private ArrayList<Car> winnerList = new ArrayList<Car>();

	public void play() {
		carsList = InputView.carsList();
		gameCount = InputView.gameCount();
		race(carsList, gameCount);
		pickWinner();
		printWinner();
	}

	public void race(ArrayList<Car> carsList, int gameCount) {
		for (int i = 0; i < gameCount; i++) {
			playTurn(carsList, gameCount);
			System.out.println();
		}
	}

	private void playTurn(ArrayList<Car> carsList, int gameCount) {
		for (Car car : carsList) {
			car.proceedOrPause();
			car.printPosition();
		}
	}

	public void pickWinner() {
		maxPosition = getMaxPosition();
		getWinnerList();
	}

	public int getMaxPosition() {
		for (int i = 0; i < carsList.size(); i++) {
			if (maxPosition < carsList.get(i).getPosition()) {
				maxPosition = carsList.get(i).getPosition();
			}
		}
		return maxPosition;
	}

	public void getWinnerList() {
		for (int i = 0; i < carsList.size(); i++) {
			if (maxPosition == carsList.get(i).getPosition()) {
				winnerList.add(carsList.get(i));
			}
		}
	}

	public void printWinner() {
		OutputView.printWinner(winnerList);
	}
}
