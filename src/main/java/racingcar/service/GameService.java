package racingcar.service;

import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validation.Validation;

public class GameService {

	private Cars cars;
	private StringBuilder result;

	private void gameServiceInit() {
		cars = new Cars();
	}

	public void inputCars(String inputStr) {
		gameServiceInit();

		Validation.checkNull(inputStr);
		addCars(inputStr);
	}

	public void inputRepeatNumber(String inputStr) {
		Validation.checkNull(inputStr);
		Validation.checkInputIsPositiveNumber(inputStr);
		cars.setRepeatNum(Integer.parseInt(inputStr));
	}

	public String getResult() {
		result = new StringBuilder();
		result.append(System.lineSeparator());

		for (int i = 0; i < cars.getRepeatNum(); i++) {
			decideMoveOrStop();
			checkSorting(i);
			checkLineSeparate(i);
		}

		return result.toString();
	}

	public String getWinner() {
		result = new StringBuilder();
		int idx = checkNumberOfWinner();

		for (int i = 0; i < idx; i++) {
			result.append(cars.getCarArrayList().get(i).getName());
			checkAddComma(i, idx);
		}

		return result.toString();
	}

	private void addCars(String inputStr) {
		for (String car : inputStr.split(",")) {
			Validation.checkCarNameLength(car);
			cars.addCarInList(car);
		}
	}

	private void decideMoveOrStop() {
		for (int i = 0; i < cars.getCarArrayList().size(); i++) {
			compareToRandomNumber(i);
		}
	}

	private void compareToRandomNumber(int carIdx) {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			cars.getCarArrayList().get(carIdx).addPosition();
		}
		printResult(carIdx);
	}

	private void printResult(int carIdx) {
		Car car = cars.getCarArrayList().get(carIdx);
		result.append(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			result.append("-");
		}
		result.append(System.lineSeparator());
	}

	private void checkLineSeparate(int num) {
		if (num != cars.getRepeatNum() - 1) {
			result.append(System.lineSeparator());
		}
	}

	private void checkSorting(int idx) {
		if (idx == cars.getRepeatNum() - 1) {
			Collections.sort(cars.getCarArrayList());
		}
	}

	private int checkNumberOfWinner() {
		int winnerNum = 1;
		Car maxPosCar = cars.getCarArrayList().get(0);
		for (int i = 1; i < cars.getCarArrayList().size(); i++) {
			if (cars.getCarArrayList().get(i).getPosition() != maxPosCar.getPosition()) {
				break;
			}
			winnerNum++;
		}

		return winnerNum;
	}

	private void checkAddComma(int idx, int len) {
		if (idx < len - 1) {
			result.append(", ");
		}
	}
}
