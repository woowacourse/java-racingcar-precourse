package racingcar.utils;

public class StringUtils {
    public static final int MIN_LENGTH_OF_CAR_NAME = 1;
    public static final int MAX_LENGTH_OF_CAR_NAME = 5;

    public static final int MIN_VALUE_OF_ROUND_NUMBER = 1;

    public static final int INITIAL_POSITION = 0;
    public static final int MIN_NUMBER_TO_CAR_TO_GO = 4;
    public static final int MIN_VALUE_OF_RANDOM_NUMBER = 1;
    public static final int MAX_VALUE_OF_RANDOM_NUMBER = 9;

    public static final int NUMBER_FOR_NO_ROUNDS_LEFT = 0;

    public static final String DELIMITER_TO_SEPARATE_CAR_NAME_INPUT = ",";

    public static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GAME_RESULT_NOTICE_PHRASE = "실행 결과";
    public static final String NUMBER_OF_ROUNDS_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String DELIMITER_BETWEEN_NAME_AND_DISTANCE_COVERED = " : ";
    public static final String MARK_FOR_DISTANCE_COVERED = "-";
    public static final String PREFIX_OF_WINNER_NOTICE = "최종 우승자 : ";
    public static final String DELIMITER_BETWEEN_WINNERS = ", ";

    public static final String SPACE = " ";
    public static final String PREFIX_OF_ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_MESSAGE_ABOUT_WRONG_NUMBER_OF_ROUNDS_INPUT = "시도 횟수는 1에서 2,146,483,647까지의 숫자만 가능합니다";
    public static final String ERROR_MASSAGE_ABOUT_EMPTY_CAR_NAMES_INPUT = "모든 자동차 이름을 한 글자 이상이어야 합니다";
    public static final String ERROR_MESSAGE_ABOUT_TOO_LONG_CAR_NAMES_INPUT = "자동차 이름은 5글자 이하여야 합니다";
    public static final String ERROR_MESSAGE_ABOUT_CONTAINING_SPACE_CAR_NAMES_INPUT = "자동차 이름에는 공백이 포함되면 안됩니다";
    public static final String ERROR_MESSAGE_ABOUT_DUPLICATED_CAR_NAMES_INPUT = "중복된 자동차 이름이 있으면 안됩니다";

    public static final String NEW_LINE = System.lineSeparator();

    private StringUtils() {
    }
}
