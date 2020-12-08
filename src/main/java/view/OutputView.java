package view;

import java.util.List;

import static domain.NamesValidator.COMMA_DELIMITER;

/**
 * 출력을 담당하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 8일
 */
public class OutputView {
    public static final String PRINT_BEFORE_RESULT = "실행 결과";
    public static final String PRINT_WINNERS = "최종 우승자: ";
    private static final int INDEX_OF_NAME = 0;
    private static final int INDEX_OF_POSITION = 1;
    private static final String DIVIDE_NAME_POSITION = " : ";
    private static final String EXPRESSION_OF_UNIT_SIZE = "-";
    private static final String ERROR_MESSAGE_STARTER = "[ERROR] ";
    private static final String SPACE_DELIMITER = " ";

    public static void printOneLine() {
        System.out.println();
    }

    public static void printNowCars(final List<List<String>> cars) {
        for (List<String> carNamePosition : cars) {
            System.out.println(formatNamePosition(carNamePosition));
        }
    }

    private static String formatNamePosition(final List<String> carNamePosition) {
        return carNamePosition.get(INDEX_OF_NAME) +
                DIVIDE_NAME_POSITION +
                printPosition(Integer.parseInt(carNamePosition.get(INDEX_OF_POSITION)));
    }

    private static String printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        while (position-- > 0) {
            stringBuilder.append(EXPRESSION_OF_UNIT_SIZE);
        }
        return stringBuilder.toString();
    }

    public static void printResult() {
        System.out.println();
        System.out.println(PRINT_BEFORE_RESULT);
    }

    public static void printWinner(final List<String> winners) {
        System.out.println(PRINT_WINNERS + String.join(COMMA_DELIMITER + SPACE_DELIMITER, winners));
    }

    public static void printError(final String errorMessage) {
        System.out.println(ERROR_MESSAGE_STARTER + errorMessage);
    }
}
