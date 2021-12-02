package racingcar.view;

public class OutputView {
    private static final String END_MESSAGE = "최종 우승자 : ";

    public void printExecutionResult(String executionResult) {
        System.out.println(executionResult);
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void printWinnerNames(String winnerNames) {
        System.out.println(END_MESSAGE + winnerNames);
    }
}