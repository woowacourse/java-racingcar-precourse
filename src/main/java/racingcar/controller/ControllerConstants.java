package racingcar.controller;

public class ControllerConstants {
    final static String SPLIT_DELIMETER = ",";

    final static String CAR_NAME_PATTERN = "^(\\w){1,5}$";
    final static String RACE_TIMES_PATTERN = "^[1-9]+[0-9]*$";

    static final String WRONG_CAR_NAMES = "자동차 이름의 길이는 5이하여야 한다.";
    static final String WRONG_RACE_TIMES = "시도 횟수는 0으로 시작하지 않는 숫자여야 한다.";
}
