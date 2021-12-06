package racingcar.utils;

public class Constant {
	public static final int MOVE_VALUE = 4;
	public static final int CAR_NAME_LENGTH_MIN = 1;
	public static final int CAR_NAME_LENGTH_MAX = 5;
	public static final char STRING_GAME_COUNT_MIN = 0;
	public static final char STRING_GAME_COUNT_MAX = 5;
	public static final char RANDOM_NUM_MIN = 0;
	public static final char RANDOM_NUM_MAX = 9;

	public static final String ASK_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ASK_GAME_COUNT = "시도할 회수는 몇회인가요?";
	public static final String PLAY_RESULT = "실행 결과";
	public static final String WINNER = "최종 우승자 : ";

	public static final String LESS_MORE_NAME_ERROR = "[ERROR] : 모든 이름은 1~5자리 문자여야 합니다.";
	public static final String CONTAIN_SAME_NAME_ERROR = "[ERROR] : 모든 이름은 중복을 허용하지 않습니다.";
	public static final String WHITE_SPACE_NAME_ERROR = "[ERROR] : 공백으로만 이루어진 이름은 허용하지 않습니다.";
	public static final String NON_NUMERIC_GAME_COUNT_ERROR = "[ERROR] : 게임 횟수는 숫자 입력만 허용합니다.";
	public static final String ZERO_GAME_COUNT_ERROR = "[ERROR] : '0'은 입력횟수로 허용하지 않습니다.";
}
