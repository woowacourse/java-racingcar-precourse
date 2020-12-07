package racingcar.view;

import racingcar.Car;
import racingcar.Cars;

public class OutputView {
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final char HYPHEN = '-';
    private static final char COLON = ':';
    private static final char SPACE = ' ';

    public static void printRequestCarNamesMessage() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
    }

    public static void printRequestAttemptNumberMessage() {
        System.out.println(REQUEST_ATTEMPT_NUMBER_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printExecutionResult(Cars cars) {
        cars.getCars()
                .stream()
                .forEach(car -> {
                    printCarName(car);
                    printDivider();
                    printProgressBar(car);
                });
        lineFeed();
    }

    private static void printCarName(Car car) {
        System.out.printf("%-5s", car.getName());
    }

    private static void printDivider() {
        System.out.print(SPACE);
        System.out.print(COLON);
        System.out.print(SPACE);
    }

    private static void printProgressBar(Car car) {
        StringBuilder sb = new StringBuilder();
        int position = car.getPosition();

        for (int i = 0; i < position; i++) {
            sb.append(HYPHEN);
        }
        System.out.println(sb.toString());
    }

    private static void lineFeed() {
        System.out.println();
    }
}
