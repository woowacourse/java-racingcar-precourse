package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import racingcar.exception.CarNameNotValidException;
import racingcar.exception.NumberFormatNotValidException;

public class Input {
	private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String COIN_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
	private static final Pattern NUMBER = Pattern.compile("[0-9]+");
	private static final int NAME_LENGTH_LIMIT = 5;
	private static String[] carNames;
	private static String input;
	private static boolean flag;

	public static String[] inputCarNames() {
		System.out.println(CAR_NAMES_INPUT_MESSAGE);
		flag = true;
		while (true) {
			carNames = readLine().split(",");
			isValidCarNames();
			if (flag) {
				break;
			}
		}
		return carNames;
	}

	public static Car[] inputCarNameToCarObj(String[] carNames) {
		Car[] cars = new Car[carNames.length];

		AtomicInteger idx = new AtomicInteger();
		Arrays.stream(carNames).forEach(name -> cars[idx.getAndIncrement()] = new Car(name));

		return cars;
	}

	public static int inputCoinNumber() {
		System.out.println(COIN_INPUT_MESSAGE);
		flag = true;
		while (true) {
			input = readLine();
			isValidNumberFormat();
			if (flag) {
				break;
			}
		}

		return Integer.parseInt(input);
	}

	private static void isValidCarNames() {
		try {
			for (int i = 0; i < carNames.length; i++) {
				String name = carNames[i];
				isNameLengthMoreOverThanLimit(name);
			}
		} catch (IllegalArgumentException ex) {

		}
	}

	private static void isNameLengthMoreOverThanLimit(String name) {
		if (name.length() > NAME_LENGTH_LIMIT) {
			flag = false;
			throw new CarNameNotValidException();
		}
	}

	private static void isValidNumberFormat() {
		if (!NUMBER.matcher(input).matches()) {
			flag = false;
			throw new NumberFormatNotValidException();
		}
	}
}
