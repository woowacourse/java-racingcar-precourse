package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
	private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String CAR_INPUT_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름을 확인하세요";
	
	public void start() {
		requestCarInput();
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
