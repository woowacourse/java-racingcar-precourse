package racingcar.utils;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.utils.RandomNumberBox.*;
import static racingcar.utils.Validator.*;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import racingcar.domain.Car;

public class Input {
	private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String COIN_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";

	private static String[] carNames;
	private static String input;
	private static boolean flag;

	public static String[] inputCarNames() {
		System.out.println(CAR_NAMES_INPUT_MESSAGE);

		while (true) {
			flag = true;
			carNames = readLine().split(",");
			flag = validateCarNames(carNames, flag);
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

	public static void inputRandomNumberToCar(Car[] cars) {
		for (Car car : cars) {
			car.moveOrStop(getRandomNumber());
		}
	}

	public static int inputCoinNumber() {
		System.out.println(COIN_INPUT_MESSAGE);

		while (true) {
			flag = true;
			input = readLine();
			flag = validateNumberFormat(input, flag);
			if (flag) {
				break;
			}
		}

		return Integer.parseInt(input);
	}

}
