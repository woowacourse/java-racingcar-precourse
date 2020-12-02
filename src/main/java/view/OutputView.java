package view;

import racingcar.RacingCars;
import utils.ValidateUtils;

public class OutputView {

    public static final String EXCEEDING_LENGTH_ERROR =
            "[ERROR] 이름은 " + ValidateUtils.MAXIMUM_NAME_LENGTH + "글자 내로 만들어야한다.";
    public static final String NO_NAME_ERROR = "[ERROR] 최소 하나의 자동차 이름을 입력해야한다.";
    public static final String NOT_NUMBER_ERROR = "[ERROR] 시도 횟수는 숫자여야 한다.";
    public static final String IS_SMALLER_THAN_MINIMAL_ERROR = "[ERROR] 시도 횟수는 0보다 커야 한다.";
    public static final String RACE_RESULT_LABEL = "실행 결과";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printCarPositionGraphic(RacingCars racingCars) {
        printRaceResultLabel();
        racingCars.printResult();
    }

    public static void printRaceResultLabel() {
        System.out.println(RACE_RESULT_LABEL);
    }
}
