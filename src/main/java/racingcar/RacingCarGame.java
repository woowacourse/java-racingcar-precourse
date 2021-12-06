package racingcar;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.OutputView;

public class RacingCarGame {
	public RacingCarGame() {

	}

	public void race() {
		String[] carNames = InputView.getCarNames();
		int moveTimes = InputView.getMoveTimes();
		List<Car> carList = carNamesToCarList(carNames);
		System.out.println("\n실행 결과");
		for (int time = 0; time < moveTimes; time++) {
			for (Car car : carList) {
				int randomValue = car.generateRandomValue();
				car.executeMoveByNumber(randomValue);
			}
			OutputView.printCarsPositionStatus(carList);
		}
		OutputView.printGameWinner(carList);
	}

	private List<Car> carNamesToCarList(String[] carNames) {
		List<Car> carList = new ArrayList<>();
		for (String name : carNames) {
			carList.add(new Car(name));
		}
		return carList;
	}

}
