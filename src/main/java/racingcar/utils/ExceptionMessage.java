package racingcar.utils;

public class ExceptionMessage {
	public static final String ERROR_MESSAGE = "[ERROR] ";

	// CAR_NAME
	public static final String CAR_NAME_NULL = ERROR_MESSAGE + "자동차 이름으로 공백이 입력될 수 없습니다.";
	public static final String CAR_OUTOF_RANGE = ERROR_MESSAGE + "자동차 이름은 " + Constant.CAR_NAME_LENGTH + "자 이하만 가능합니다.";
	public static final String CAR_NAME_DUPLICATE = ERROR_MESSAGE + "자동차 이름이 중복되었습니다.";

	// TRY
	public static final String TRY_TYPE_FAIL = ERROR_MESSAGE + "잘못된 형식 입니다. 0 이상의 정수를 입력해주세요.";
	public static final String TRY_RANGE_FAIL = ERROR_MESSAGE + "범위를 벗어난 값입니다. 0 이상의 정수를 입력해주세요.";

}
