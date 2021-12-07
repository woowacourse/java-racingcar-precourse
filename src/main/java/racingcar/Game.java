package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
	private int gameCount = 0;
	private int maxPosition = 0;
	private ArrayList<Car> carsList = new ArrayList<Car>();
	private ArrayList<Car> winnerList = new ArrayList<Car>();
	private ArrayList<String> stringWinnerList = new ArrayList<String>();

	public void play() {
		carsList = getCarsList();
		gameCount = getGameCount();
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
			OutputView.printPosition(car.getCarName(), car.getPosition());
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
		extractWinnersNames(winnerList);
		OutputView.printWinner(stringWinnerList);
	}

	public void extractWinnersNames(ArrayList<Car> winnerList) {
		for (int i = 0; i < winnerList.size(); i++) {
			stringWinnerList.add(winnerList.get(i).getCarName());
		}
	}

	public ArrayList<Car> getCarsList() {
		List<String> carsNameList = InputView.carNamesInput();
		createCarsList(carsNameList);
		return carsList;
	}

	public void createCarsList(List<String> carsNameList) {
		for (int i = 0; i < carsNameList.size(); i++) {
			carsList.add(new Car(carsNameList.get(i)));
		}
	}

	public int getGameCount() {
		String stringGameCount = InputView.gameCountInput();
		gameCount = Integer.parseInt(stringGameCount);

		return gameCount;
	}
}


