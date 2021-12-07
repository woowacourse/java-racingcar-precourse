package racingcar.utils;

public class Message {
	public static final String INPUT_NAMES_INSTRUCTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_COUNT_INSTRUCTION = "시도할 회수는 몇회인가요?";
	public static final String ERROR = "[ERROR] ";
	public static final String FINAL_WINNER_INSTRUCTION = "최종 우승자 : ";
	public static final String RESULT_INSTRUCTION = "실행 결과";
	public static final String REQUEST_NULL_OR_EMPTY_MESSAGE = "빈칸 입력은 허용하지 않는다.";
	public static final String REQUEST_VALID_FIRST_VALUE_MESSAGE = "정상적인 이름을 입력하세요.";
	public static final String REQUEST_VALID_COUNT_OF_NAMES_MESSAGE = "최소 2개 이상 입력하세요.";
	public static final String REQUEST_DUPLICATES_OF_NAMES_MESSAGE = "중복값을 입력할 수 없습니다.";
	public static final String REQUEST_LENGTH_EVERY_NAME_MESSAGE =
		"각 Name은(는) " + Constant.MIN_LENGTH + " ~ " + Constant.MAX_LENGTH + "자 사이로 입력해주세요.";
	public static final String REQUEST_MESSAGE_VALID_FORMAT_OF_COUNT = "시도 횟수는 숫자여야 한다.";
	public static final String REQUEST_MESSAGE_VALID_RANGE_COUNT = "정상 범위(" + Constant.MIN_RANGE + "이상)가 아닙니다";
}
