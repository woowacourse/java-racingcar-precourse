package racingcar.utils;

public class StringConstants {
    public static final int MIN_LENGTH_OF_CAR_NAME = 1;
    public static final int MAX_LENGTH_OF_CAR_NAME = 5;

    public static final int MIN_VALUE_OF_ROUND_NUMBER = 1;

    public static final int INITIAL_POSITION = 0;
    public static final int MIN_NUMBER_TO_CAR_TO_GO = 4;
    public static final int NUMBER_TO_ADD_WHEN_CAR_GO = 1;
    public static final int MIN_VALUE_OF_RANDOM_NUMBER = 1;
    public static final int MAX_VALUE_OF_RANDOM_NUMBER = 9;

    public static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GAME_RESULT_NOTICE_PHRASE = "실행 결과";
    public static final String NUMBER_OF_ROUNDS_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String DELIMITER_BETWEEN_NAME_AND_DISTANCE_RECORD = " : ";
    public static final String MARK_FOR_DISTANCE_RECORD = "-";
    public static final String PREFIX_OF_WINNER_NOTICE = "최종 우승자 : ";
    public static final String DELIMITER_BETWEEN_WINNERS = ", ";

    public static final String SPACE = " ";

    public static final String NEW_LINE = System.lineSeparator();

    private StringConstants() {
    }
}
