package config;

public class ErrorMessage {
	private final String CAR_NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 5자 이하만 가능하다.";
	private final String NOT_CORRECT_REPEAT_NUM_ERROR = "[ERROR] 시도 횟수는 숫자여야 한다.";

	public String getCAR_NAME_LENGTH_ERROR() {
		return CAR_NAME_LENGTH_ERROR;
	}

	public String getNOT_CORRECT_REPEAT_NUM_ERROR() {
		return NOT_CORRECT_REPEAT_NUM_ERROR;
	}
}
