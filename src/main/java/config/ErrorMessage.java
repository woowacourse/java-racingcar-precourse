package config;

public class ErrorMessage {
	private final String CAR_NAME_LENGTH_ERROR = "자동차 이름은 5자 이하만 가능하다.";
	private final String NOT_CORRECT_REPEAT_NUM_ERROR = "시도 횟수는 자연수여야 한다.";
	private final String NULL_ERROR = "빈 값이 올 수 없습니다.";

	public String getCAR_NAME_LENGTH_ERROR() {
		return CAR_NAME_LENGTH_ERROR;
	}

	public String getNOT_CORRECT_REPEAT_NUM_ERROR() {
		return NOT_CORRECT_REPEAT_NUM_ERROR;
	}

	public String getNULL_ERROR() {
		return NULL_ERROR;
	}
}
