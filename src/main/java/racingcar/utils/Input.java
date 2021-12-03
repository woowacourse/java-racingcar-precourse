package racingcar.utils;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.utils.Validator.*;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import racingcar.domain.Car;

public enum Input {
	INPUT_INSTANCE;
	private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String COIN_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
	private RandomNumberBox randomNumberBox;
	private String[] carNames;
	private String input;
	private boolean flag;

	public void initInputInstance(RandomNumberBox randomNumberBox) {
		this.randomNumberBox = randomNumberBox;
	}

	public String[] inputCarNames() {
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

	public Car[] inputCarNameToCarObj(String[] carNames) {
		Car[] cars = new Car[carNames.length];

		AtomicInteger idx = new AtomicInteger();
		Arrays.stream(carNames).forEach(name -> cars[idx.getAndIncrement()] = new Car(name));

		return cars;
	}

	public void inputRandomNumberToCar(Car[] cars) {
		for (Car car : cars) {
			car.moveOrStop(randomNumberBox.getRandomNumber());
		}
	}

	public int inputCoinNumber() {
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
