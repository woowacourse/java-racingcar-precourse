package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final String ERROR_PREFIX = "[ERROR] ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printCurrent(String current) {
        System.out.println(current);
    }

    public void printResult(List<String> winners) {
        StringJoiner result = new StringJoiner(", ", "최종 우승자 : ", "");
        for (String name : winners) {
            result.add(name);
        }
        System.out.println(result.toString());
    }
}
