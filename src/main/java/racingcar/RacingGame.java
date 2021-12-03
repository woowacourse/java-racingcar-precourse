package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

public class RacingGame {
	static final String SPLIT = ",";
	static final String SPLIT_WITH_SPACE = ", ";
	static final int CAR_NAME_LIMIT = 5;

	static final String ERROR_PREFIX = "[ERROR] ";
	static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	static final String ATTEMPT_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
	static final String RESULT_TITLE = "실행 결과";
	static final String RESULT = "최종 우승자 : ";

	static final String EMPTY_CAR_NAME_ERROR = "빈값이 존재합니다.";
	static final String CAR_NAME_LENGTH_ERROR = "자동차의 이름은 " + CAR_NAME_LIMIT + "자 이하로 제한되어 있습니다.";
	static final String EMPTY_ATTEMPT_ERROR = "시도할 횟수를 입력해주세요.";
	static final String ATTEMPT_ONLY_NUMBER_ERROR = "숫자만 입력해주세요.";
	static final String ATTEMPT_NEGATIVE_NUMBER_ERROR = "0이상의 수를 입력해주세요.";

	Car[] cars;
	int attempt;

	public void play() {
		setCars();
		setAttempt();

		start();
		showWinner();
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

		for (String input : inputs) {
			String error_message = validateName(input.trim());

			if (!error_message.equals("")) {
				showError(error_message);
				inputs = getNames();
				break;
			}
		}

		return inputs;
	}

	String validateName(String str) {
		if (checkInputEmpty(str)) {
			return ERROR_PREFIX + EMPTY_CAR_NAME_ERROR;
		}

		if (checkInputLength(str)) {
			return ERROR_PREFIX + CAR_NAME_LENGTH_ERROR;
		}

		return "";
	}

	boolean checkInputEmpty(String str) {
		return str.equals("");
	}

	boolean checkInputLength(String str) {
		return str.length() > CAR_NAME_LIMIT;
	}

	boolean checkInputNumber(String str) {
		try {
			int number = Integer.parseInt(str);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	boolean checkInputNegativeNumber(String str) {
		return Integer.parseInt(str) < 0;
	}

	void showError(String error_message) {
		System.out.println(new IllegalArgumentException(error_message).getMessage());
	}


	void setAttempt() {
		this.attempt = Integer.parseInt(getAttempt());
	}

	String getAttempt() {
		System.out.println(ATTEMPT_INPUT_MESSAGE);
		String input = readLine();

		String error_message = validateAttempt(input);

		if (!error_message.equals("")) {
			showError(error_message);
			input = getAttempt();
		}

		return input.trim();
	}

	String validateAttempt(String str) {
		str = str.trim();

		if (checkInputEmpty(str)) {
			return ERROR_PREFIX + EMPTY_ATTEMPT_ERROR;
		}

		if (!checkInputNumber(str)) {
			return ERROR_PREFIX + ATTEMPT_ONLY_NUMBER_ERROR;
		}

		if (checkInputNegativeNumber(str)) {
			return ERROR_PREFIX + ATTEMPT_NEGATIVE_NUMBER_ERROR;
		}

		return "";
	}


	void start() {
		System.out.println(RESULT_TITLE);

		for (int i = 0; i < this.attempt; i++) {
			for (int j = 0; j < this.cars.length; j++) {
				Car car = this.cars[j];
				car.move();
				car.showPosition();
			}
			System.out.println();
		}
	}


	void showWinner() {
		System.out.println(RESULT + getWinners());
	}

	String getWinners() {
		int maxPosition = 0;
		int nowPosition;

		String winners = "";
		for (int i = 0; i < this.cars.length; i++) {
			nowPosition = this.cars[i].getPosition();
			if (nowPosition > maxPosition) {
				maxPosition = nowPosition;
				winners = "";
			}

			if (nowPosition != maxPosition) {
				continue;
			}

			if (!winners.equals("")) {
				winners += SPLIT_WITH_SPACE;
			}
			winners += this.cars[i].getName();
		}

		return winners;
	}
}