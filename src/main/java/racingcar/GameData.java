package racingcar;

public class GameData {

	public static final int START_NUMBER = 0;
	public static final int END_NUMBER = 9;
	public static final int CRITERIA_NUMBER = 4;
	public static final int CARNAME_LIMIT = 5;

	public static final String WINNER_MESSAGE = "최종 우승자 : ";
	public static final String CARNAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String RESULT_MESSAGE = "실행결과";
	public static final String RESULT_FORMAT = "%s : %s";

	public static final String TURNCOUNT_TOO_SMALL_ERROR_MESSAGE = "[ERROR] 시도 횟수가 너무 작습니다.";
	public static final String TURNCOUNT_NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
	public static final String CARNAME_DUPLICATED_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복되서는 안된다.";
	public static final String CARNAME_EMPTY_ERROR_MESSAGE = "[ERROR] 자동차 이름엔 공백이 포함되서는 안된다.";
	public static final String CARNAME_LIMIT_ERROR_MESSAGE = String.format("[ERROR] 자동차 이름은 %d 이하여야 한다.",
		CARNAME_LIMIT);
}
