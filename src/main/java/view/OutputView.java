package view;

import java.util.List;

import static domain.NamesValidator.COMMA_DELIMITER;
import static domain.racingcar.Car.INDEX_OF_NAME;
import static domain.racingcar.Car.INDEX_OF_POSITION;

/**
 * 출력을 담당하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 3일
 */
public class OutputView {
    private static final String EXPRESSION_OF_UNIT_SIZE = "-";
    private static final String SPACE_DELIMITER = " ";
    private static final String ERROR_MESSAGE_STARTER = "[ERROR] ";
    private static final String DIVIDE_NAME_POSITION = " : ";

    public static void printOneLine() {
        System.out.println();
    }

    public static void printNowCars(List<List<String>> cars) {
        for (List<String> oneCarInfo : cars) {
            System.out.println(formatNamePosition(oneCarInfo));
        }
    }

    private static String formatNamePosition(List<String> oneCarInfo) {
        return oneCarInfo.get(INDEX_OF_NAME) +
                DIVIDE_NAME_POSITION +
                printPosition(Integer.parseInt(oneCarInfo.get(INDEX_OF_POSITION)));
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
        System.out.println("실행 결과");
    }

    public static void printWinner(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(COMMA_DELIMITER + SPACE_DELIMITER, winners));
    }

    public static void printError(String errorMessage) {
        System.out.println(ERROR_MESSAGE_STARTER + errorMessage);
    }
}
