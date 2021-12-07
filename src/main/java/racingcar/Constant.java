package racingcar;

public class Constant {
    public static final String INPUT_MESSAGE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_MESSAGE_TRY_TIMES = "시도할 회수는 몇회인가요?";
    public static final String RACE_PROCESS = "실행 결과";
    public static final String FINAL_WINNER = "최종 우승자 : ";
    public static final String FINAL_WINNER_JOIN_DELIMITER = ", ";

    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String ERROR_EMPTY_NAME = ERROR_PREFIX + "이름에 공백이 있을 수 없습니다.";
    public static final String ERROR_OVERLAP_NAME = ERROR_PREFIX + "이름은 중복될 수 없습니다.";
    public static final String ERROR_RIGHT_LENGTH_NAME = ERROR_PREFIX + "1~5자 사이의 이름만 가능합니다.";

    public static final String ERROR_NOT_NUMBER_TIMES = ERROR_PREFIX + "시도 횟수는 정수여야 합니다.";
    public static final String ERROR_POSITIVE_INTEGER = ERROR_PREFIX + "시도 횟수는 양의 정수여야 합니다.";
}
