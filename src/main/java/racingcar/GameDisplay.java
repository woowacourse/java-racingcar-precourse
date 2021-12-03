package racingcar;

public class GameDisplay {

    private static final String EXECUTION_RESULT_MESSAGE = "실행결과";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String COLON = " : ";

    public void printInputNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputRoundMessage() {
        System.out.println(INPUT_ROUND_MESSAGE);
    }

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
