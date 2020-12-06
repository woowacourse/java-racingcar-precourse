package racingcar;

public class Constant {
    public static final String PARTICIPATING_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACE_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RACE_PROCESS = "실행 결과";
    public static final String FINAL_WINNER = "최종 우승자: ";

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_CAR_NAME_EMPTY = ERROR_PREFIX + "비어있는 이름은 입력받을 수 없습니다.";
    public static final String ERROR_CAR_NAME_LENGTH = ERROR_PREFIX + "1 ~ 5자의 이름을 입력해야 합니다.";
    public static final String ERROR_CAR_NAME_DUPLICATE = ERROR_PREFIX + "중복된 이름을 입력할 수 없습니다.";
    public static final String ERROR_RACE_NUMBER = ERROR_PREFIX + "올바른 입력의 회수가 아닙니다";
    public static final String ERROR_RACE_NUMBER_POSITIVE_INTEGER = ERROR_PREFIX + "회수는 1이상의 수여야합니다.";

    public static final String BLANK = " ";
    public static final String EMPTY_NAME = "";
    public static final String DELIMITER = ",";
    public static final String COMMA = ", ";
    public static final String COLON = " : ";
    public static final String FORWARD_SIGN = "-";

    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_RACE_NUMBER = 1;

    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    public static final int FORWARD_CONDITION = 4;
}
