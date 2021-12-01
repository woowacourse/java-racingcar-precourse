package racingcar.constant;

public class GameConstants {
	public static final String CAR_NAME_DELIMITER = ",";
	public static final String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ASK_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String ATTEMPT_NUMBER_REGEX = "^[1-9]{1}[0-9]*$";
	public static final int MAXIMUM_NAME_LENGTH = 5;

	public static final String NUMBER_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 5자 이하만 가능하다.";
	public static final String ATTEMPT_NUMBER_REGEX_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1이상의 수여야 한다.";
	public static final String ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 2,147,483,647이하의 수여야 한다.";
}
