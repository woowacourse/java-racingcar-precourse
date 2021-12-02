package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

public class RacingGame {
	static final String SPLIT = ",";
	static final int CAR_NAME_LIMIT = 5;

	static final String ERROR_PREFIX = "[ERROR] ";
	static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	Car[] cars;

	public void play() {
		setCars();
	}

	void setCars() {
		String[] carNames = getNames();

		this.cars = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			this.cars[i] = new Car(carNames[i].trim());
		}
	}

	String[] getNames() {
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		String[] inputs = readLine().split(SPLIT, -1);

		for (String input: inputs) {
			String error_message = validateName(input.trim());

			if (!error_message.equals("")) {
				System.out.println(new IllegalArgumentException(error_message).getMessage());
				inputs = getNames();
				break;
			}
		}

		return inputs;
	}

	String validateName(String str) {
		if (checkInputEmpty(str)) {
			return ERROR_PREFIX + "빈값이 존재합니다.";
		}

		if (checkInputLength(str)) {
			return ERROR_PREFIX + "자동차의 이름은 " + CAR_NAME_LIMIT + "자 이하로 제한되어 있습니다.";
		}

		return "";
	}

	boolean checkInputEmpty(String str) {
		return str.equals("");
	}

	boolean checkInputLength(String str) {
		return str.length() > CAR_NAME_LIMIT;
	}
}