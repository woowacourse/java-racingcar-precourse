package racingcar;

public class Constant {
    public static final int MINIMUM_NUMBER_OF_CARS_FOR_GAME = 1;
    public static final int MAXIMUM_LENGTH_OF_NAMES = 5;
    public static final int MINIMUM_NUMBER_OF_ATTEMPT = 1;
    public static final String PLEASE_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PLEASE_INPUT_ATTEMPT = "시도할 회수는 몇회인가요?";
    public static final String ERROR = "[ERROR] ";
    public static final String ERROR_NO_NAMES = ERROR + "1개 이상의 이름을 입력해야 한다.";
    public static final String ERROR_MORE_THAN_FIVE_CHARACTERS = ERROR + "5글자 이하의 이름을 입력해야 한다.";
    public static final String ERROR_ATTEMPT_MUST_BE_A_NUMBER = ERROR + "시도 횟수는 숫자여야 한다.";
    public static final String ERROR_ATTEMPT_MUST_BE_MORE_THAN_ZERO = ERROR + "1 이상의 숫자를 입력해야 한다.";
}
