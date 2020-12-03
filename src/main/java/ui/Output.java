package ui;

import java.util.List;

public class Output {
    private static final String REQUEST_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ATTEMPTS_COUNT = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자";
    private static final String ONE_STEP = "-";

    public static void printRequestRacingCarNames() {
        System.out.println(REQUEST_RACING_CAR_NAMES);
    }

    public static void printRequestAttemptsCount() {
        System.out.println(REQUEST_ATTEMPTS_COUNT);
    }

    public static void willPrintResult() {
        System.out.println(RESULT);
    }

    public static void printResult(String name, int position) {
        String movingResult = "";
        for (int i = 0; i < position; i++) {
            movingResult += ONE_STEP;
        }
        System.out.println(name + " : " + movingResult);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print(WINNER + ": ");
        System.out.println(String.join(", ", winners));
    }
}
