package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.ConsoleViewConstants;
import racingcar.domain.Car;
import racingcar.service.Converter;
import racingcar.service.Validator;

public class ConsoleView {
	private Converter converter;
	private Validator validator;

	public ConsoleView() {
		converter = new Converter();
		validator = new Validator();
	}

	public List<Car> getCarNames() {
		List<String> carNames;
		do {
			askCarNames();
			String inputString = readLine();
			carNames = converter.convertStringToList(inputString);
		}while(checkGetAgainCarNames(carNames));

		return converter.convertStringListToCarList(carNames);
	}

	private void askCarNames() {
		System.out.println(ConsoleViewConstants.ASK_CAR_NAMES);
	}

	private String readLine() {
		return Console.readLine();
	}

	private boolean checkGetAgainCarNames(List<String> carNames) {
		if(validateCarNames(carNames)) {
			return false;
		}
		notifyErrorWithCarNames();
		return true;
	}

	private boolean validateCarNames(List<String> carNames) {
		try {
			validator.checkCarsNameSize(carNames);
		}catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	private void notifyErrorWithCarNames() {
		System.out.println(ConsoleViewConstants.ERROR_CAR_NAMES);
	}

	public int getRuntimeNumber() {
		String numberString;
		do {
			askRuntimeNumber();
			numberString = readLine();
		}while(checkGetAgainRuntimeNumber(numberString));

		return converter.convertStringToInt(numberString);
	}

	private void askRuntimeNumber() {
		System.out.println(ConsoleViewConstants.ASK_RUNTIME_NUMBER);
	}

	private boolean checkGetAgainRuntimeNumber(String numberString) {
		if(validateRuntimeNumber(numberString)) {
			return false;
		}
		notifyErrorWithRuntimeNumber();
		return true;
	}

	private boolean validateRuntimeNumber(String numberString) {
		try {
			validator.checkNumber(numberString);
		}catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	private void notifyErrorWithRuntimeNumber() {
		System.out.println(ConsoleViewConstants.ERROR_RUNTIME_NUMBER);
	}
}
