package ui;

import java.util.List;

public class Output {
    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자";
    private static final String ONE_STEP = "-";

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
