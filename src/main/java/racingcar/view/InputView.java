package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private final OutputView outputView;

    InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<String> inputCarName() {
        outputView.printInputRacing();
        String input = Console.readLine();
        String[] split = input.split(",");
        return Arrays.asList(split);
    }

    public int inputTryCount() {
        outputView.printInputTryCount();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
