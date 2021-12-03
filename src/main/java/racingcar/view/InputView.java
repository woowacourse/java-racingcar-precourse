package racingcar.view;

import static racingcar.util.SymbolicConstantUtil.*;
import static racingcar.util.ValidationUtil.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String REQUEST_ROUND_VALUE = "시도할 회수는 몇회인가요?";
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
			isValidateBlank(carName);
			isValidateNotInput(carName);
			isValidateLength(carName);
		}
		isValidateDuplicated(carsName);
	}

	public static int getInputRound() {
		printRequestRound();
		try {
			String inputRound = Console.readLine();
			validateInputRound(inputRound);
			return Integer.parseInt(inputRound);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			return getInputRound();
		}
	}

	private static void validateInputRound(String inputRound) {
		isValidateNumber(inputRound);
		isValidateMinimumOne(inputRound);
		isValidateNotInput(inputRound);
	}

	private static void printRequestCarsName() {
		System.out.println(REQUEST_CARS_NAME);
	}

	private static void printRequestRound() {
		System.out.println(REQUEST_ROUND_VALUE);
	}

	private static void printErrorMessage(Exception e) {
		System.out.println(ERROR_MESSAGE + e.getMessage());
	}
}
