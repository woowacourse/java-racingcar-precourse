package racingcar.view;

import racingcar.util.Symbol;
import racingcar.util.ViewMessage;

public class RaceOutputView {

    public void outputExecutionResult(String result) {
        StringBuilder output = new StringBuilder();

        output.append(Symbol.NEW_LINE).append(ViewMessage.OUTPUT_EXECUTION_RESULT.getMessage()).append(Symbol.NEW_LINE);
        output.append(result);
        System.out.print(output);
    }

    public void outputWinner(String winners) {
        StringBuilder output = new StringBuilder();

        output.append(ViewMessage.OUTPUT_WINNER.getMessage()).append(Symbol.COLON_SPACE);
        output.append(winners);
        System.out.println(output);
    }
}
