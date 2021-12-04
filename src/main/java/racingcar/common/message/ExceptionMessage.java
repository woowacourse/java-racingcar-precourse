package racingcar.common.message;

import racingcar.common.model.ResultMessage;

public enum ExceptionMessage implements ResultMessage {
	CAR_NAME_EMPTY_OR_NULL_EXCEPTION_MESSAGE(BASIC_ERROR_MESSAGE + "null 또는 빈 문자열이다."),
	CAR_NAME_FORMAT_EXCEPTION_MESSAGE(BASIC_ERROR_MESSAGE + "이름은 5글자 이하만 가능하다."),
	CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE(BASIC_ERROR_MESSAGE + "중복된 이름이 존재한다."),
	TRY_NUMBER_FORMAT_EXCEPTION_MESSAGE(BASIC_ERROR_MESSAGE + "시도 횟수는 숫자여야 한다."),
	TRY_NUMBER_POSITIVE_EXCEPTION_MESSAGE(BASIC_ERROR_MESSAGE + "시도 횟수는 0보다 커야한다.");

	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
