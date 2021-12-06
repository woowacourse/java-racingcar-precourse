package racingcar.view;

import racingcar.domain.Car;

public class OutputDisplay {

    private static final String COLON = " : ";
    private static final String EXECUTION_RESULT_MESSAGE = "실행결과";

    public void printEmptyLine() {
        System.out.println();
    }

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printEachRoundResult(Car car) {
        System.out.println(car.getCarName() + COLON + car.getSpeed());
    }

    public void printWinner(String makeWinnerPrintFormat) {
        System.out.println(makeWinnerPrintFormat);
    }

    public void printErrorMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }

}
