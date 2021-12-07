package racingcar.constant;

public class StringConstant {
	public static final String CAR_LIST_DIVIDER = ",";
	public static final String CAR_RESULT_DIVIDER = " : ";
	public static final String MOVE_RESULT = "-";

	public static String ERROR_PREFIX = "[ERROR] ";
	public static String CAR_NAME_OVER = "자동차 이름은 공백을 포함하여 5자리를 넘을 수 없습니다.\n";
	public static String CAR_NAME_NULL = "자동차 이름은 공백을 제외하고 최소 한자리 이상이어야 합니다.\n";
	public static String CAR_NAME_OVERLAPPED = "자동차 이름은 중복될 수 없습니다.\n";

	public static String EXECUTE_NOT_NUMBER = "시도 횟수는 숫자여야 한다.\n";
	public static String EXECUTE_NOT_POSITIVE = "시도 횟수는 0보다 큰 정수이어야 한다.\n";

	public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String PROCESS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String RESULT_INIT_MESSAGE = "\n실행 결과";

	public static final String WINNER_PREFIX_MESSAGE = "최종 우승자 : ";
	public static final String WINNER_LIST_DIVIDER = ", ";
}
