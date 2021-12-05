package racingcar;

/**
 * <h1>레이싱 게임 진행을 위해 필요한 메시지</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-05(V1.0)
 */

public class RacingGameMessage {

	public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

	public static final String INPUT_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static final String INPUT_RACING_TURNS = "시도할 회수는 몇회인가요?";

	public static final String INVALID_TURNS = ERROR_MESSAGE_PREFIX + "시도 회수는 숫자여야 합니다";

	public static final String GAME_RESULT = "실행 결과";

	private static final String INVALID_RACING_CAR_NAME = "은 5자 이하여야 합니다";

	private static final String WINNER_LIST = "최종 우승자 : ";

	public static String getCarNameErrorMessage(final String carName) {
		return ERROR_MESSAGE_PREFIX + carName + INVALID_RACING_CAR_NAME;
	}

	public static String getWinnerListMessage(final String winnerList) {
		return WINNER_LIST + winnerList;
	}

	public static void printCarPosition(int carPosition, final String carName) {
		System.out.print(carName + " : ");
		while(carPosition-- > 0) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
}
