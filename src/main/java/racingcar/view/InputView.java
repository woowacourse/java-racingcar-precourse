package racingcar.view;

import static racingcar.util.SymbolicConstantUtil.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.ValidationUtil;

public class InputView {
	private static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ERROR_MESSAGE = "[ERROR] ";

	public static String getInputCarsName() {
		printRequestCarsName();
		try {
			String inputCarsName = Console.readLine();
			validateInputCarsName(inputCarsName);
			return inputCarsName;
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			return getInputCarsName();
		}
	}

	private static void validateInputCarsName(String inputCarsName) {
		String[] carsName = inputCarsName.split(COMMA);
		for (String carName : carsName) {
			ValidationUtil.isValidateBlank(carName);
			ValidationUtil.isValidateNotInput(carName);
			ValidationUtil.isValidateLength(carName);
		}
		ValidationUtil.isValidateDuplicated(carsName);
	}

	private static void printRequestCarsName() {
		System.out.println(REQUEST_CARS_NAME);
	}

	private static void printErrorMessage(Exception e) {
		System.out.println(ERROR_MESSAGE + e.getMessage());
	}
}
