package constant;

import static constant.RacingCarGameRule.*;

public class RacingCarGameMessage {

	public static final String DELIMITER = ",";
	public static final String SPACE = " ";
	public static final String COLON = " : ";

	public static final String INPUT_MESSAGE_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + DELIMITER + ") 기준으로 구분)";
	public static final String INPUT_MESSAGE_NUMBER_OF_TIMES = "시도할 회수는 몇회인가요?";

	public static final String ERROR = "[ERROR]";
	public static final String ERROR_MESSAGE_NAME_LENGTH =
		ERROR + "자동차 이름은 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이하만 가능합니다.";
	public static final String ERROR_MESSAGE_NAME_DUPLICATION = ERROR + "자동차 이름은 중복될 수 없습니다.";
	public static final String ERROR_MESSAGE_INPUT_IS_NOT_NUBMER = ERROR + "숫자를 입력해주세요.";

	public static final String RESULT_MESSAGE = "실행 결과";
	public static final String WINNER_MESSAGE = "최종 우승자";
}
