package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
	private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String CAR_INPUT_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름을 확인하세요";
	private static final String TURN_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String TURN_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
	
	public void start() {
		requestCarInput();
		requestTurnInput();
	}

	private int requestTurnInput() {
		System.out.println(TURN_INPUT_MESSAGE);
		return receiveTurnInput();
	}

	private int receiveTurnInput() {
		String turnInput = Console.readLine();

		try {
			Validator.validateTurnInput(turnInput);
		} catch (IllegalArgumentException e) {
			System.out.println(TURN_INPUT_ERROR_MESSAGE);
			return receiveTurnInputAgain();
		}
		return Integer.parseInt(turnInput);
	}

	private int receiveTurnInputAgain() {
		return receiveTurnInput();
	}

	private String requestCarInput() {
		System.out.println(CAR_INPUT_MESSAGE);
		return receiveCarInput();
	}

	private String receiveCarInput() {
		String carInput = Console.readLine();

		try {
			Validator.validateCarInput(carInput);
		} catch (IllegalArgumentException e) {
			System.out.println(CAR_INPUT_ERROR_MESSAGE);
			return receiveCarInputAgain();
		}
		return carInput;
	}

	private String receiveCarInputAgain() {
		return receiveCarInput();
	}
}
