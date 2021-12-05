package view.output;

import static util.StringRepeater.repeat;

import dto.AttemptResult;
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
    public void showAttemptResult(final List<AttemptResult> results) {
        StringBuilder output = new StringBuilder();
        results.forEach(result -> output
                .append(result.getName())
                .append(COLON_DELIMITER)
                .append(repeat(POSITION_SYMBOL, result.getPosition()))
                .append(NEW_LINE)
        );
        System.out.println(output);
    }

    @Override
    public void showWinners(final List<Car> winners) {
        StringBuilder output = new StringBuilder("최종 우승자");
        output.append(COLON_DELIMITER);
        IntStream.range(0, winners.size())
                .forEach(index -> output.append(winners.get(index).getName()).append(ENUMERATION_DELIMITER));
        output.deleteCharAt(output.lastIndexOf(ENUMERATION_DELIMITER));
        System.out.println(output);
    }
}
