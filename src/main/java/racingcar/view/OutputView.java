package racingcar.view;

import racingcar.domain.Car;
import java.util.Collections;

public class OutputView {
    private static final String BAR = "-";
    private static final String SPACE_DELIMITER = "";
    private static final String EXECUTION_RESULT = "\n실행 결과";
    private static final String TURN_RESULT = "%s : %s\n";
    private static final String FINAL_WINNERS = "최종 우승자 : %s\n";

    public static void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printTurnResult(Car car) {
        System.out.printf(TURN_RESULT, car.getName(), convertPositionToBar(car.getPosition()));
    }

    private static String convertPositionToBar(int position) {
        return String.join(SPACE_DELIMITER, Collections.nCopies(position, BAR));
    }

    public static void printErrorLog(String msg) {
        System.out.println(msg);
    }

    public static void printWinners(String winners) {
        System.out.printf(FINAL_WINNERS, winners);
    }
}
