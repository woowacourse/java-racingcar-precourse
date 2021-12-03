package racingcar;

public class Constant {
    public static final int MINIMUM_NUMBER_OF_CARS_FOR_GAME = 1;
    public static final int MAXIMUM_LENGTH_OF_NAMES = 5;
    public static final int MINIMUM_NUMBER_OF_ATTEMPT = 1;
    public static final int MAXIMUM_NUMBER_OF_RANDOM = 9;
    public static final int MINIMUM_NUMBER_OF_RANDOM = 0;
    public static final int NUMBER_FOR_MOVE = 4;
    public static final String PLEASE_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PLEASE_INPUT_ATTEMPT = "시도할 회수는 몇회인가요?";
    public static final String EXECUTION_RESULT = "실행결과";
    public static final String STANDARD_FOR_EXECUTION_RESULT = " : ";
    public static final String LETTERS_FOR_POSITION = "-";
    public static final String FINAL_WINNER = "최종 우승자 : ";
    public static final String STANDARD_FOR_FINAL_WINNER = ", ";
    public static final String ERROR = "[ERROR] ";
    public static final String ERROR_NO_NAMES = ERROR + "1개 이상의 이름을 입력해야 한다.";
    public static final String ERROR_NO_SPACE = ERROR + "이름에 공백은 허용되지 않는다.";
    public static final String ERROR_MORE_THAN_FIVE_CHARACTERS = ERROR + "5글자 이하의 이름을 입력해야 한다.";
    public static final String ERROR_NO_DUPLICATED_NAMES = ERROR + "중복된 이름은 허용되지 않는다.";
    public static final String ERROR_ATTEMPT_MUST_BE_A_NUMBER = ERROR + "시도 횟수는 숫자여야 한다.";
    public static final String ERROR_ATTEMPT_MUST_BE_MORE_THAN_ZERO = ERROR + "1 이상의 숫자를 입력해야 한다.";
}
