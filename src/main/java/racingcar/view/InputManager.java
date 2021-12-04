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
		}while(checkGetAgainCarNames(carNames));

		return converter.convertStringListToCarList(carNames);
	}

	private String askCarNames() {
		System.out.println(ViewConstants.ASK_CAR_NAMES);
		return readLine();
	}

	private boolean checkGetAgainCarNames(List<String> carNames) {
		if(validateCarNames(carNames)) {
			return false;
		}
		printErrorWithCarNames();
		return true;
	}

	private boolean validateCarNames(List<String> carNames) {
		try {
			validator.checkCarNameSize(carNames);
		}catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	private void printErrorWithCarNames() {
		System.out.println(ViewConstants.ERROR_CAR_NAMES);
	}

	public int getNumberOfRaces() {
		String numberString;
		do {
			numberString = askNumberOfRaces();
		}while(checkGetAgainNumberOfRaces(numberString));

		return converter.convertStringToInt(numberString);
	}

	private String askNumberOfRaces() {
		System.out.println(ViewConstants.ASK_RUNTIME_NUMBER);
		return readLine();
	}

	private boolean checkGetAgainNumberOfRaces(String numberString) {
		if(validateNumberOfRaces(numberString)) {
			return false;
		}
		printErrorWithNumberOfRaces();
		return true;
	}

	private boolean validateNumberOfRaces(String numberString) {
		try {
			validator.checkNumberOfRaces(numberString);
		}catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	private void printErrorWithNumberOfRaces() {
		System.out.println(ViewConstants.ERROR_RUNTIME_NUMBER);
	}

	private String readLine() {
		return Console.readLine();
	}
}
