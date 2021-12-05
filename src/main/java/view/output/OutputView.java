package view.output;

import dto.AttemptResult;
import dto.Winners;

import java.util.List;
import java.util.stream.IntStream;

import static util.StringRepeater.repeat;

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
    public void showWinners(final Winners winners) {
        List<String> winnerNames = winners.getWinnerNames();
        StringBuilder output = new StringBuilder("최종 우승자");
        output.append(COLON_DELIMITER);
        IntStream.range(0, winnerNames.size())
                .forEach(index -> output.append(winnerNames.get(index)).append(ENUMERATION_DELIMITER));
        output.deleteCharAt(output.lastIndexOf(ENUMERATION_DELIMITER));
        System.out.println(output);
    }
}
