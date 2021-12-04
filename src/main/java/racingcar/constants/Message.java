package racingcar.constants;

public class Message {
	public static final String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ASK_STAGES = "시도할 회수는 몇회인가요?";
	public static final String EXECUTE_RESULT = "실행 결과";
	public static final String WINNERS = "최종 우승자 : ";
	public static final String ERROR_INVALID_NAME_FORMAT = "[ERROR] 자동차의 이름은 중복이 안되는 1~5글자 입니다";
	public static final String ERROR_INVALID_STAGE_VALUE = "[ERROR] 시도할 횟수는 0이 아닌 숫자여야 합니다";

	private Message() {
	}
}
