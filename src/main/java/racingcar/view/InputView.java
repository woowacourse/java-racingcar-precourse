package racingcar.view;

import static racingcar.view.constants.Format.INPUT_NAMES_DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.view.constants.InputMessage;
import racingcar.view.util.FormatParser;
import racingcar.view.util.NumberParser;

public class InputView {
    public List<String> inputCarNames() {
        System.out.println(InputMessage.CAR_NAMES);
        String line = Console.readLine();
        return FormatParser.split(line, INPUT_NAMES_DELIMITER);
    }

    public int inputMoveCount() {
        System.out.println(InputMessage.MOVE_COUNT);
        String line = Console.readLine();
        System.out.println();
        return NumberParser.parseDigit(line);
    }
}
