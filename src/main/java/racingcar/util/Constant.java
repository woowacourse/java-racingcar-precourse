package racingcar.util;

public final class Constant {
	public static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static final String CAR_NAME_SEPARATOR = ",";

	public static final int CAR_NAME_MIN_SIZE = 1;
	public static final int CAR_NAME_MAX_SIZE = 5;

	public static final String ERROR_MESSAGE = "[ERROR] ";
	public static final String ERROR_MESSAGE_CAR_NAME = ERROR_MESSAGE + "자동차 이름은 5자리 이하여야 하며, 쉼표(,) 기준으로 구분해야 한다.";
}
