package racingcar.constant;

public class Constants {

    /*
     * view에서 보여주는 문구
     */

    public static final String PLEASE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PLEASE_INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    public static final String GAME_RESULT = "실행 결과";
    public static final String WINNERS = "최종 우승자: ";

    /*
     * ERROR 문구
     */

    public static final String ERROR_NO_COMMA = "[ERROR] 자동차 이름은 \",\"로 구분되야 한다.";
    public static final String ERROR_CAR_NAME_LENGTH_GREATER_THAN_FIVE = "[ERROR] 자동차 이름은 5자 이하여야 한다.";
    public static final String ERROR_CAR_NAME_LENGTH_LESS_THAN_ONE = "[ERROR] 자동차 이름은 1자 이상이여야 한다.";
    public static final String ERROR_ONLY_ONE_CAR = "[ERROR] 2대 이상의 자동차의 이름을 입력해야한다.";
    public static final String ERROR_SAME_NAME_CAR = "[ERROR] 서로 다른 이름의 자동차 이름을 입력해야 한다.";
    public static final String ERROR_NUMBER_OF_ATTEMPTS_IS_NOT_NATURAL_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";


    /*
     * 원시값
     */

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final int MIN_TOTAL_CARS_AMOUNT = 2;
    public static final int MOVEMENT_RANGE = 1;
    public static final int POSITION_INIT_VALUE = 0;
    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    public static final int STANDARD_VALUE_FOR_MOVE_FORWARD = 4;
    public static final int MIN_INDEX_VALUE = 0;
}
