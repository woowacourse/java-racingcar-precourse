package racingcar;

public class Constant {
	public static final String CAR_NAME_OVER_STANDARD_ERROR_MESSAGE = "차의 이름은 %d자 이하만 가능하다.";
	public static final String CAR_NAME_NOT_NULL_ERROR_MESSAGE = "차의 이름에 null 값이 들어갔다.";
	public static final String SHOW_ERROR_MESSAGE = "[ERROR] %s";
	public static final String TRY_CNT_IS_NOT_NEGATIVE_MESSAGE = "시도 횟수는 음수가 될 수 없다.";
	public static final String TRY_CNT_IS_NOT_NUMBER_MESSAGE = "시도 횟수는 숫자여야 한다.";

	public static final String INPUT_EVERY_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_TRY_CAR_MOVING_CNT = "시도할 회수는 몇회인가요?";

	public static final String CAR_SPLIT_REGEX = ",";
	public static final String NUMBER_REGEX = "-?\\d+";
	public static final int CAR_NAME_LETTERS_STANDARD = 5;
}
