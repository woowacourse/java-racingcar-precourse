package racingcar.utils;

public enum Message {
	INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	INPUT_ATTEMPT_NUMBER("시도할 회수는 몇회인가요?"),
	EXECUTION_RESULT("실행 결과"),

	ERROR_HEADER("[ERROR]"),
	ERROR_INVALID_ATTEMPT_NUMBER(ERROR_HEADER.getMessage() + "시도 횟수는 숫자여야 합니다."),
	ERROR_INVALID_CAR_NAME(ERROR_HEADER.getMessage() + "자동차 이름이 5자 이하여야 합니다."),
	ERROR_DUPLICATE_CAR_NAME(ERROR_HEADER.getMessage() + "자동차 이름은 서로 달라야 합니다."),
	ERROR_CAR_NAME_LIST_SIZE(ERROR_HEADER.getMessage() + "자동차 이름의 개수는 2개 이상이어야 합니다"),
	ERROR_INPUT_IS_BLANK(ERROR_HEADER.getMessage() + "공백을 입력하셨습니다. 다시 입력해주세요."),
	WINNER_RESULT("최종 우승자 : "),
	;

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
