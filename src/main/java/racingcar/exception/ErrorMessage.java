package racingcar.exception;

public enum ErrorMessage {
	CAR_NAME_LENGTH_ERROR("자동차 이름은 5자 이하만 가능하다."),
	NOT_CORRECT_REPEAT_NUM_ERROR("시도 횟수는 자연수여야 한다."),
	NULL_ERROR("빈 값이 올 수 없습니다."),
	CAR_NAME_DISTINCT_ERROR("자동차 이름은 중복될 수 없습니다."),
	CAR_NAME_ONE_ERROR("자동차 이름은 한개일 수 없습니다.");

	private String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
