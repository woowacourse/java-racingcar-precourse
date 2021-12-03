package racingcar.util;

public class Constants {
	public static final char MAX_CHAR_FOR_NUMBER = '9';
	public static final char MIN_CHAR_FOR_NUMBER = '0';
	public static final int MAX_CAR_NAME_LENGTH = 5;
	public static final int MIN_CAR_NAME_LENGTH = 1;
	public static final int MIN_CAR_COUNT = 1;
	public static final int MIN_DRIVE_COUNT = 1;
	public static final int MAX_RANDOM_NUMBER = 9;
	public static final int MIN_RANDOM_NUMBER = 0;
	public static final String COMMA = ",";

	public static final String ERROR = "[ERROR]";
	public static final String ERROR_CAR_NAME_LENGTH_OVER = ERROR + " 자동차 이름은 " + MAX_CAR_NAME_LENGTH + "이하여야 합니다.";
	public static final String ERROR_CAR_NAME_LENGTH_UNDER = ERROR + " 자동차 이름은 " + MIN_CAR_NAME_LENGTH + "이상이어야 합니다.";
	public static final String ERROR_CAR_COUNT_EMPTY = ERROR + " 입력된 자동차가 없습니다.";
	public static final String ERROR_CHAR_IS_NOT_NUMBER = ERROR + " 숫자를 입력해야 합니다.";
	public static final String ERROR_DRIVE_COUNT_INVALID = ERROR + " 운행 횟수는 1 이상이어야 합니다.";
	public static final String ERROR_SAME_CAR_NAME = ERROR + " 중복되는 자동차 이름이 있으면 안됩니다.";

	public static final String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String MESSAGE_INPUT_DRIVE_COUNT = "시도할 회수는 몇회인가요?";
	public static final String MESSAGE_SEMICOLON_WITH_SPACE = " : ";
	public static final String MESSAGE_POSITION = "-";
}
