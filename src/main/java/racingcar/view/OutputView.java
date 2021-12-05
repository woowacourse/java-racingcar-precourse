package racingcar.view;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;

public class OutputView {

    private static final String RACE_RESULT_TITLE = "실행 결과";

    private static final String RACE_RESULT_BODY = "%s : %s\n";
    private static final String RACE_RESULT_POSITION = "-";

    private static final String RACE_RESULT_WINNER_TITLE = "최종 우승자 : ";
    private static final String RACE_RESULT_WINNER_PRINT_DELIMITER = ",";

    private OutputView() {
    }

    public static void outputResultTitle() {
        System.out.println(RACE_RESULT_TITLE);
    }

    public static void outputNowRoundResult(List<Car> cars) {
        cars.forEach(OutputView::printNowCarResult);
        System.out.println();
    }

    private static PrintStream printNowCarResult(Car car) {
        return System.out.printf(RACE_RESULT_BODY, car.name(), calculateCarPosition(car.position()));
    }

    private static String calculateCarPosition(int position) {
        StringBuilder result = new StringBuilder();
        IntStream.range(0, position)
            .forEach(index -> result.append(RACE_RESULT_POSITION));
        return result.toString();
    }

    public static void outputRacingGameWinners(List<String> winners) {
        System.out.print(RACE_RESULT_WINNER_TITLE);
        System.out.println(String.join(RACE_RESULT_WINNER_PRINT_DELIMITER, winners));
    }
}
