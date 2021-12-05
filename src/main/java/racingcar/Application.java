package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.ConsoleInputStrategy;
import racingcar.view.InputStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputStrategy inputStrategy = new ConsoleInputStrategy();
        InputView inputView = new InputView(inputStrategy);
        OutputView outputView = new OutputView();
        RacingCarController racingCarController = new RacingCarController(inputView, outputView);
        racingCarController.run();
    }
}
