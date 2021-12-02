package racingcar;

public class Constant {
	public static int NAME_MAX_LENGTH = 5;
	public static int NAME_MIINUM_LENGTH = 1;
	public static int PROCEED_CRITERIA = 4;
	public static String CAR_NAME_PARSER = ",";
	public static String CAR_NAMES_INPUT_ALARM_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + CAR_NAME_PARSER + ") 기준으로 구분)";
	public static String GAME_TRIAL_COUNT_INPUT_ALARM_MESSAGE = "시도할 회수는 몇회인가요?";
	// 에러문
	public static String NAME_MAX_LENGTH_EXCEED_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능하다.";
	public static String NAME_MINIMUN_LENGTH_UNDER_ERROR_MESSAGE = "[ERROR] 자동차 이름은 최소 1글자여야 한다.";
}
