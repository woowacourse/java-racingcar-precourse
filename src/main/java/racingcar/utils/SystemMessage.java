package racingcar.utils;

public class SystemMessage {
	private static final String ERROR_MESSAGE = "[ERROR]";

	public static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ERROR_INPUT_CAR_NAME_LENGTH = ERROR_MESSAGE + " 자동차 이름은 5글자 이하여야 합니다.";
	public static final String ERROR_INPUT_CAR_NAME_EMPTY_OR_BLANK = ERROR_MESSAGE + " 자동차 이름은 빈 문자열이거나 공백만 있을 수 없습니다.";
	public static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String ERROR_INPUT_ROUND_IS_NOT_NUMERIC = ERROR_MESSAGE + " 시도 횟수는 숫자여야 합니다.";
	public static final String ERROR_INPUT_ROUND_IS_NOT_POSITIVE_NUMBER = ERROR_MESSAGE + " 양수를 입력해야 합니다.";
	public static final String RACE_RESULT_MESSAGE = "실행 결과";
	public static final String WINNER_MESSAGE = "최종 우승자 : ";
}
