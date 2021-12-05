package view;

import static util.StringRepeater.repeat;

import model.car.Car;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView implements OutputDisplayable {
    private static final String ENUMERATION_DELIMITER = ", ";
    private static final String POSITION_SYMBOL = "-";
    private static final String COLON_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";

    @Override
    public void printOperationResultLetters() {
        System.out.println("실행결과");
    }

    @Override
    public void showAttemptResult(final List<Car> cars) {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> result
                .append(car.getName())
                .append(COLON_DELIMITER)
                .append(repeat(POSITION_SYMBOL, car.getPosition()))
                .append(NEW_LINE)
        );
        System.out.println(result);
    }

    @Override
    public void showWinners(final List<Car> winners) {
        StringBuilder result = new StringBuilder("최종 우승자");
        result.append(COLON_DELIMITER);
        IntStream.range(0, winners.size())
                .forEach(index -> result.append(winners.get(index).getName()).append(ENUMERATION_DELIMITER));
        result.deleteCharAt(result.lastIndexOf(ENUMERATION_DELIMITER));
        System.out.println(result);
    }
}
