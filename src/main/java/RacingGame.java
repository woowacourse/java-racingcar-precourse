import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import domain.Car;
import domain.Rule;
import utils.InputHandler;
import utils.InputValidator;
import view.InputView;
import view.OutputView;

public class RacingGame {
	private ArrayList<Car> cars = new ArrayList<>();
	private int tryNumber = 0;

	public void play() {
		buildCars();
		getTryNumber();
		OutputView.printResultMessage();
		getResult();
		OutputView.printCarsPosition(cars);
		OutputView.printWinners(Rule.getWinnerNames(cars));
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

	private void getTryNumber() {
		tryNumber = InputView.tryNumber();
		if(!InputValidator.isValidNumber(tryNumber)) {
			throw new InputMismatchException("시도 횟수는 1 이상 이어야 합니다.");
		}
	}

	private void getResult() {
		for (int i = 0; i < tryNumber; i++) {
			cars.forEach(Car::tryToGo);
			OutputView.printCarsPosition(cars);
		}
	}
}
