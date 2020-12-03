package racingcar.view;

public class ErrorView {
    private static final String INPUT_CAR_NAME_LOG_ERROR = "자동차 이름은 5자 이하만 가능하다.";
    private static final String INPUT_RACE_NUM_LOG_ERROR_NOT_NUMBER = "시도 횟수는 숫자여야 한다.";
    private static final String ERROR_LOG_PREFIX = "[ERROR] ";

    public static void printCarNameInputLogError(){
        System.out.println(ERROR_LOG_PREFIX + INPUT_CAR_NAME_LOG_ERROR);
    }

    public static void printRaceNumInputLogErrorNotNumber(){
        System.out.println(ERROR_LOG_PREFIX + INPUT_RACE_NUM_LOG_ERROR_NOT_NUMBER);
    }
}
