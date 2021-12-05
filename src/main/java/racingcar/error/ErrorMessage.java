package racingcar.error;

public enum ErrorMessage {
	INVALID_LENGTH("[ERROR] 이름은 5글자를 넘길 수 없습니다."),
 	OVERLAP("[ERROR] 이름이 중복됩니다."),
 	NOT_NUMBER("[ERROR] 시도 횟수는 숫자여야합니다."),
	OVER_MAX("[ERROR] 시도 횟수가 100을 넘길 수 없습니다."),
	UNDER_MIN("[ERROR] 시도 횟수는 1이상을 입력해주세요.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
