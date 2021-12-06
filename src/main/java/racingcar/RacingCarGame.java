package racingcar;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.OutputView;

public class RacingCarGame {
	private static final int DEFAULT_CAR_POSITION = 0;

	public RacingCarGame() {

	}

	public void race() {
		String[] carNames = InputView.getCarNames();
		int moveTimes = InputView.getMoveTimes();
		List<Car> carList = carNamesToCarList(carNames);
		OutputView.printGameResultMessage();
		for (int time = 0; time < moveTimes; time++) {
			raceRound(carList);
		}
		List<Car> winnerList = findGameWinners(carList);
		OutputView.printGameWinner(winnerList);
	}

	private void raceRound(List<Car> carList) {
		for (Car car : carList) {
			int randomValue = car.generateRandomValue();
			car.executeMoveByNumber(randomValue);
		}
		OutputView.printCarsPositionStatus(carList);
	}

	private static List<Car> findGameWinners(List<Car> carList) {
		int winningPosition = findWinningPosition(carList);
		List<Car> winnerList = new ArrayList<>();
		for (Car car : carList) {
			if (car.isWinningPosition(winningPosition)) {
				winnerList.add(car);
			}
		}
		return winnerList;
	}

	private static int findWinningPosition(List<Car> carList) {
		int winningPosition = DEFAULT_CAR_POSITION;
		for (Car car : carList) {
			winningPosition = Math.max(winningPosition, car.getPosition());
		}
		return winningPosition;
	}

	private List<Car> carNamesToCarList(String[] carNames) {
		List<Car> carList = new ArrayList<>();
		for (String name : carNames) {
			carList.add(new Car(name));
		}
		return carList;
	}
}
