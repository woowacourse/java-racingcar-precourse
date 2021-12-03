package constants;

public class RacingCarConstant {
	public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
	public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

	public static final String DELIMITER = ",";
	public static final Character DELIMITER_CHARACTER = ',';
	public static final String COLON = " : ";
	public static final String PROGRESS_BAR = "-";
	public static final String COMMA = ", ";

	public static final int CAR_MOVE_LOWER_BOUND = 0;
	public static final int CAR_MOVE_UPPER_BOUND = 9;
	public static final int CAR_MOVE_CHECK_NUM = 4;
	public static final int CAR_MOVE = 1;

	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String CAR_NAME_DUPLICATE_ERROR = "자동차 이름은 중복되어서는 안된다";
	public static final String CAR_NAME_WRONG_LENGTH_ERROR = "자동차 이름의 길이는 1~5자여야 한다";
	public static final String CAR_NAME_EMPTY_ERROR = "자동차 이름에 빈 이름을 넣어서는 안된다";
	public static final String CAR_NAME_WRONG_END_ERROR = "자동차 이름의 입력이 ,로 끝나서는 안된다";
	public static final String GAME_COUNT_NOT_DIGIT_ERROR = "시도 횟수는 숫자여야 한다";
	public static final String GAME_COUNT_UPPER_ZERO_ERROR = "시도 횟수는 0이상의 숫자여야 한다";
	public static final String GAME_COUNT_EMPTY_ERROR = "시도 횟수에 빈 입력을 넣어서는 안된다";
}
