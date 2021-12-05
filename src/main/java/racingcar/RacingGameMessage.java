package racingcar;

/**
 * <h1>레이싱 게임 진행을 위해 필요한 메시지</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-05(V1.0)
 */

public class RacingGameMessage {

	/** 사용자가 유효하지 않은 데이터를 입력했을때 출력하는 에러메시지의 접두사 */
	public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

	/** 사용자가 자동차 이름을 입력하도록 안내하는 메시지 */
	public static final String INPUT_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	/** 사용자가 레이싱 게임 턴 수를 입력하도록 안내하는 메시지 */
	public static final String INPUT_RACING_TURNS = "시도할 회수는 몇회인가요?";

	/** 사용자가 유효하지 않은 레이싱 게임 턴 수를 입력했을때 사용되는 에러 메시지 */
	public static final String INVALID_TURNS = ERROR_MESSAGE_PREFIX + "시도 회수는 숫자여야 합니다";

	/** 레이싱 게임 결과를 안내하는 메시지 */
	public static final String GAME_RESULT = "실행 결과";

	/** 사용자가 잘못된 자동차 이름을 입력했을때 출력되는 에러 메시지 뒷부분 */
	private static final String INVALID_RACING_CAR_NAME = "은 5자 이하여야 합니다";

	/** 레이싱 게임의 최종 우승자를 알려주는 메시지 */
	private static final String WINNER_LIST = "최종 우승자 : ";

	/**
	 * 사용자가 잘못된 자동차 이름을 입력했을때 출력되는 에러 메시지를 반환
	 *
	 * @param carName 유효하지 않은 자동차 이름
	 * @return String 에러 메시지
	 */
	public static String getCarNameErrorMessage(final String carName) {
		return ERROR_MESSAGE_PREFIX + carName + INVALID_RACING_CAR_NAME;
	}

	/**
	 * 레이싱 게임 최종 우승자 안내 메시지를 반환한다
	 *
	 * @param winnerList 우승자 리스트
	 * @return String 최종 우승자 안내 메시지
	 */
	public static String getWinnerListMessage(final String winnerList) {
		return WINNER_LIST + winnerList;
	}

	/**
	 * 매 턴에 출력되야 하는 차량의 위치를 출력한다
	 *
	 * @param carPosition 차의 현재 위치
	 * @param carName 차의 이름
	 */
	public static void printCarPosition(int carPosition, final String carName) {
		System.out.print(carName + " : ");
		while(carPosition-- > 0) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
}
