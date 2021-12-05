package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.ViewConstants;
import racingcar.domain.Car;
import racingcar.service.Converter;
import racingcar.service.Validator;

public class InputManager {

	private final Converter converter;
	private final Validator validator;

	public InputManager() {
		converter = new Converter();
		validator = new Validator();
	}

	public List<Car> getCars() {
		List<String> carNames;
		do {
			String inputString = askCarNames();
			carNames = converter.convertStringToList(inputString);
		}while(checkErrorWithCarNames(carNames));

		return converter.convertStringListToCarList(carNames);
	}

	private String askCarNames() {
		System.out.println(ViewConstants.ASK_CAR_NAMES);
		return readLine();
	}

	private boolean checkErrorWithCarNames(List<String> carNames) {
		if(validateCarNames(carNames) && validateCarsSize(carNames)) {
			return false;
		}
		return true;
	}

	private boolean validateCarNames(List<String> carNames) {
		try {
			validator.checkCarNames(carNames);
		}catch (IllegalArgumentException e) {
			printError(ViewConstants.ERROR_CAR_NAMES);
			return false;
		}
		return true;
	}

	private boolean validateCarsSize(List<String> carNames) {
		try {
			validator.checkCarsSize(carNames);
		}catch (IllegalArgumentException e) {
			printError(ViewConstants.ERROR_CAR_SIZE);
			return false;
		}
		return true;
	}

	public int getNumberOfRaces() {
		String numberString;
		do {
			numberString = askNumberOfRaces();

		}while(checkErrorWithNumberOfRaces(numberString));

		return converter.convertStringToInt(numberString);
	}

	private String askNumberOfRaces() {
		System.out.println(ViewConstants.ASK_RUNTIME_NUMBER);
		return readLine();
	}

	private boolean checkErrorWithNumberOfRaces(String numberString) {
		if(!validateNumberOfRacesDigit(numberString)) {
			return true;
		}

		int numberOfRaces = converter.convertStringToInt(numberString);
		if (!validateNumberOfRacesRange(numberOfRaces)) {
			return true;
		}

		return false;
	}

	private boolean validateNumberOfRacesDigit(String numberString) {
		try {
			validator.checkNumberOfRacesDigit(numberString);
		} catch (IllegalArgumentException e) {
			printError(ViewConstants.ERROR_NUMBER_OF_RACES);
			return false;
		}
		return true;
	}

	private boolean validateNumberOfRacesRange(int numberOfRaces) {
		try {
			validator.checkNumberOfRacesRange(numberOfRaces);
		} catch (IllegalArgumentException e) {
			printError(ViewConstants.ERROR_NUMBER_OF_RACES_RANGE);
			return false;
		}
		return true;
	}

	private String readLine() {
		return Console.readLine();
	}

	private void printError(String error) {
		System.out.println(error);
	}
}
