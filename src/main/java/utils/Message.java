package utils;

public class Message {

	public static final String RACING_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

	public static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";
	public static final String PROGRESS_BAR = "-";
	public static final String FINAL_WIN_MESSAGE = "최종 우승자 : ";
	public static final String SEPARATOR = ", ";

	public static final int CAR_NAME_MAX_LENGTH = 5;
	public static final int NUMBER_MIN_VALUE = 0;
	public static final int NUMBER_MAX_VALUE = 9;
	public static final int FORWARD_CONDITION_NUMBER = 4;

	public static final String NAME_BLANK_MESSAGE = "[ERROR] 자동차 이름을 생략하지 말고 입력하세요.";
	public static final String NAME_LENGTH_EXCEED_MESSAGE = "[ERROR] 자동차 이름을 5자 이하로 입력하세요.";
	public static final String NAME_DUPLICATION_MESSAGE = "[ERROR] 자동차 이름이 중복되지 않게 입력하세요.";

	public static final String NUMBER_FORMAT_MESSAGE = "[ERROR] 숫자를 입력하세요.";
	public static final String NUMBER_NOT_POSITIVE_MESSAGE = "[ERROR] 0 또는 음수가 입력되었습니다. 양수를 입력하세요.";
}
