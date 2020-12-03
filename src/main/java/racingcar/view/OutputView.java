package racingcar.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String ATTEMPT_RESULT_MESSAGE = "%s : %s\n";
    private static final String WINNER_MESSAGE = "최종 우승자: ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResultScore(String carName, String positionBars) {
        System.out.printf(ATTEMPT_RESULT_MESSAGE, carName, positionBars);
    }
}
