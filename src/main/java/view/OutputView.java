package view;

import java.util.List;

import static domain.NameValidator.COMMA_DELIMITER;

public class OutputView {
    public static final String EXPRESSION_OF_UNIT_SIZE = "-";
    public static final String SPACE_DELIMITER = " ";
    public static final String ERROR_MESSAGE_STARTER = "[ERROR] ";
    public static final String DIVIDE_NAME_POSITION = " : ";

    public void printOneLine() {
        System.out.println();
    }

    public void printNowCars(String name, int position) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(name).append(DIVIDE_NAME_POSITION).append(printPosition(position)).toString());
    }

    private String printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(EXPRESSION_OF_UNIT_SIZE);
        }
        return stringBuilder.toString();
    }

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printWinner(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(COMMA_DELIMITER + SPACE_DELIMITER, winners));
    }

    public void printError(String errorMessage) {
        System.out.println(ERROR_MESSAGE_STARTER + errorMessage);
    }
}
