package racingcar.util;

public class Constants {
	public static final int MAX_CAR_NAME_LENGTH = 5;
	public static final int MIN_CAR_NAME_LENGTH = 1;
	public static final int MIN_CAR_COUNT = 1;
	public static final String COMMA = ",";

	public static final String ERROR = "[ERROR]";
	public static final String ERROR_CAR_NAME_LENGTH_OVER = ERROR + " 자동차 이름은 " + MAX_CAR_NAME_LENGTH + "이하여야 합니다.";
	public static final String ERROR_CAR_NAME_LENGTH_UNDER = ERROR + " 자동차 이름은 " + MIN_CAR_NAME_LENGTH + "이상이어야 합니다.";
	public static final String ERROR_CAR_COUNT_EMPTY = ERROR + "입력된 자동차가 없습니다.";
}
