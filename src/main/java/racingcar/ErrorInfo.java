package racingcar;

public enum ErrorInfo {
	LENGTH("[ERROR] 이름은 5글자를 넘길 수 없습니다."),
 	OVERLAP("[ERROR] 이름이 중복됩니다."),
 	NUMBER("[ERROR] 시도 횟수는 숫자여야합니다."),
	MAX("[ERROR] 시도 횟수가 100을 넘길 수 없습니다."),
	MIN("[ERROR] 시도 횟수는 1이상을 입력해주세요.");

	private final String message;

	ErrorInfo(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
