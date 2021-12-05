package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.ConsoleInputStrategy;
import racingcar.view.InputStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputStrategy inputStrategy = new ConsoleInputStrategy();
        RacingCarController racingCarController = new RacingCarController(inputView, outputView, inputStrategy);
        racingCarController.run();
    }
}
