package utils;

public class ConstantUtils {

    public static final int MAX_CAR_NAME = 5;
    public static final int MIN_CAR_NAME = 1;
    public static final int MIN_LAP = 1;
    public static final int MAX_NO_MOVE = 3;
    public static final int MIN_RANDOM_ZERO = 0;
    public static final int MAX_RANDOM_NINE = 9;

    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String OVER_FIVE_LETTERS = ERROR_PREFIX + "자동차 이름은 5자 이하이어야 한다.";
    public static final String EMPTY_LETTER = ERROR_PREFIX + "모든 자동차는 이름이 있어야 한다.";
    public static final String MUST_BE_NUMBER = ERROR_PREFIX + "시도 횟수는 숫자여야 한다.";
    public static final String MUST_BE_POSITIVE_INTEGER = ERROR_PREFIX + "시도 횟수는 양수여야 한다.";

    public static final String ASKING_MOVES_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String ASKING_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String NAMES_DELIMITER = ",";

    public static final String FINAL_WINNER = "최종 우승자: ";
    public static final String RACE_RESULT = "실행결과";
    public static final String NAME_RESULT_SEPARATOR = " : ";
    public static final String RACING_BAR = "-";
    public static final String WINNERS_JOIN_DELIMITER = ", ";

}
