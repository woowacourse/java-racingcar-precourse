package racingcar.view;

import racingcar.util.Symbol;
import racingcar.util.ViewMessage;

public class RaceOutputView {

    public void outputExecutionResult() {
        System.out.println(Symbol.NEW_LINE + ViewMessage.OUTPUT_EXECUTION_RESULT.getMessage());
    }

    public void outputWinner(String winners) {
        StringBuilder output = new StringBuilder();

        output.append(ViewMessage.OUTPUT_WINNER.getMessage()).append(Symbol.COLON_SPACE);
        output.append(winners);
        System.out.println(output);
    }
}
