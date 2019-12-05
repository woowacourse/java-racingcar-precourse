import java.util.ArrayList;
import java.util.Collections;

import domain.Car;
import domain.Rule;
import utils.InputHandler;
import view.InputView;
import view.OutputView;

public class RacingGame {
	private ArrayList<Car> cars = new ArrayList<>();

	public void play() {
		buildCars();
		int tryNumber = getTryNumber();
		OutputView.printResultMessage();
		getResult(tryNumber);
		OutputView.printCarsPosition(cars);
		OutputView.printWinners(Rule.getWinnersName(cars));
	}

	private void buildCars() {
		ArrayList<String> carNames = getCarNames();
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	private ArrayList<String> getCarNames() {
		ArrayList<String> result = new ArrayList<>();
		String[] carNames = InputHandler.splitByComma(InputView.carNames());

		Collections.addAll(result, carNames);
		return result;
	}

	private int getTryNumber() {
		return InputView.tryNumber();
	}

	private void getResult(int tryNumber) {
		for (int i = 0; i < tryNumber; i++) {
			cars.forEach(Car::tryToGo);
			OutputView.printCarsPosition(cars);
		}
	}
}
