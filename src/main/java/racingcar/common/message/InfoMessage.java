package racingcar.common.message;

import racingcar.common.model.ResultMessage;

public enum InfoMessage implements ResultMessage {
	REQUEST_CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	REQUEST_TRY_COUNT_INPUT_MESSAGE("시도할 회수는 몇회인가요?");

	private final String message;

	InfoMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
