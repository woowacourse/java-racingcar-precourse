package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";
    private static final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String MORE_THAN_ONE_WINNER = ", ";
    private static final String NEW_LINE = "\n";
    private static final String COLON = " : ";
    private static final String DASH = "-";

    public static void printExecutionMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printResult(List<Car> carList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList) {
            stringBuilder.append(car.getName()).append(COLON).append(makeDash(car.getPosition())).append(NEW_LINE);
        }

        System.out.println(stringBuilder.toString());
    }

    private static String makeDash(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(DASH);
        }

        return stringBuilder.toString();
    }

    public static void printWinner(List<String> winnersOutput) {
        System.out.print(OUTPUT_WINNER_MESSAGE);
        System.out.println(String.join(MORE_THAN_ONE_WINNER, winnersOutput));
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
