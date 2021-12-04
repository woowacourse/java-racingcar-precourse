package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedList;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.ErrorMessage;
import racingcar.exception.ErrorResponse;
import racingcar.validation.Validation;

public class GameService {

	public Cars cars;

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

	public void postResult() {

	}

	public void postWinner() {

	}

	private void addCars(String inputStr){
		for (String car : inputStr.split(",")) {
			Validation.checkCarNameLength(car);
			cars.addCarInList(car);
		}
	}
}
