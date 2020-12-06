package racingcar;

public class GameConstants {
    public static final String INPUT_ROUND_MESSAGE = "시도할 횟수를 입력해주세요: ";
    public static final String INVALID_ROUND_INPUT_NOT_INTEGER_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
    public static final String INVALID_ROUND_INPUT_SMALLER_THAN_ZERO_MESSAGE = "[ERROR] 시도 횟수는 1보다 큰 숫자여야 한다.";
    public static final String INPUT_CAR_NAMES_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)하여 입력해주세요: ";
    public static final String INVALID_CAR_NAMES_ZERO_NAME_MESSAGE = "[ERROR] 하나 이상의 자동차 이름을 쉼표로 구분하여 입력해주세요";
    public static final String INVALID_CAR_NAMES_ZERO_LENGTH_MESSAGE = "[ERROR] 자동차의 이름은 1이상이어야 합니다";
    public static final String INVALID_CAR_NAMES_OVER_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야 합니다";
    public static final String SIMULARE_RESULT_MESSAGE = "실행 결과";
    public static final String FINAL_WINNER = "최종 우승자: ";
    public static final String SHOW_RACING_NAME_MARGIN = " : ";
    public static final String RACING_ROAD = "-";
    public static final String CAR_NAME_DELIMETER = ",";
    public static final String CAR_NAME_SPLITTER = ",";

    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
}
