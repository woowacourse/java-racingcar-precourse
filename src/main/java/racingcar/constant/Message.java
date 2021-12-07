package racingcar.constant;

public class Message {
	public static final String CAR_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
	public static final String EXECUTION_RESULT = "실행 결과";
	public static final String FINAL_WINNER = "최종 우승자 : %s";
	public static final String RESULT_OF_STEP = "%s : %s";
	public static final String BLOCK = "-";

	public static final String ERROR_LONG_CAR_NAME = "[ERROR] 자동차의 이름은 5글자 미만이어야 합니다.";
	public static final String ERROR_COUNT_IS_INTEGER = "[ERROR] 횟수 입력은 숫자만 가능합니다";
	public static final String ERROR_COUNT_CANNOT_BE_ZERO = "[ERROR] 0 이상의 수를 입력해야합니다.";
}