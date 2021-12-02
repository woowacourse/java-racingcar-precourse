package racingcar.view;

public enum Message {
	INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	INPUT_ATTEMPT_NUMBER("시도할 회수는 몇회인가요?"),
	ERROR_HEADER("[ERROR]"),
	ERROR_INVALID_ATTEMPT_NUMBER(ERROR_HEADER.getMessage() + "시도 횟수는 숫자여야 합니다."),
	ERROR_INVALID_CAR_NAME(ERROR_HEADER.getMessage() + "자동차 이름이 5자 이하여야 합니다."),
	;

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
