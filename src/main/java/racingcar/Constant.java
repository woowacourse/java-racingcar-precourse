package racingcar;

public class Constant {
	public static int NAME_MAX_LENGTH = 5;
	public static int NAME_MIINUM_LENGTH = 1;
	public static int PROCEED_CRITERIA = 4;
	public static int MINIMUM_GAME_ROUND = 1;
	public static int MAX_RANDOM_VALUE = 9;
	public static int MINIMUM_RANDOM_VALUE = 0;
	public static String CAR_NAME_PARSER = ",";
	public static String CAR_NAMES_INPUT_ALARM_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + CAR_NAME_PARSER + ") 기준으로 구분)";
	public static String GAME_TRIAL_COUNT_INPUT_ALARM_MESSAGE = "시도할 회수는 몇회인가요?";
	public static String GAME_RESULT_ALARM_MESSAGE = "실행 결과";
	public static String CAR_PROGRESS_SIGN = "-";
	public static String WINNING_ANNOUNCEMENT_MESSAGE = "최종 우승자 : ";
	// 에러문
	public static String NAME_MAX_LENGTH_EXCEED_ERROR_MESSAGE = "[ERROR] 자동차 이름은 " + NAME_MAX_LENGTH + "자 이하만 가능하다.";
	public static String NAME_MINIMUN_LENGTH_UNDER_ERROR_MESSAGE = "[ERROR] 자동차 이름은 최소 "+ NAME_MIINUM_LENGTH +"글자여야 한다.";
	public static String MINIMUM_GAME_ROUND_UNDER_ERROR_MESSAGE = "[ERROR] 게임 횟수는 최소" + MINIMUM_GAME_ROUND + "회여야 한다.";
}
