package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class Output {
    private static final String CARS_NAME_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REPETITION_NUMBER_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NOT_FOUND_MAX_POSITION_CAR = "가장 멀리간 차를 찾을 수 없습니다.";
    private static final String NEXT_LINE = "\n";
    private static final String DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_RESULT_MESSAGE = "최종 우승자";
    private static StringBuilder stringBuilder = new StringBuilder();

    private Output() {
    }

    public static void carNameInputGuideMessage() {
        println(CARS_NAME_INPUT_GUIDE_MESSAGE);
    }

    public static void numberInputGuideMessage() {
        println(REPETITION_NUMBER_INPUT_GUIDE_MESSAGE);
    }

    public static String maxPositionCarErrorMessage() {
        return NOT_FOUND_MAX_POSITION_CAR;
    }

    public static void roundResult(List<Car> cars) {
        for (Car carResult : cars) {
            stringBuilder.append(carResult.toString()).append(NEXT_LINE);
        }
        stringBuilder.append(NEXT_LINE);
    }

    public static void printAllRoundResult() {
        println(RESULT_MESSAGE);
        System.out.print(stringBuilder);
    }

    public static void printWinners(List<String> winners) {
        println(String.format("%s : %s", FINAL_WINNER_RESULT_MESSAGE,
            winners.stream().collect(Collectors.joining(DELIMITER))));
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
