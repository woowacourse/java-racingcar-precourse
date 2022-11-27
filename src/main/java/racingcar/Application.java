package racingcar;

import racingcar.domain.RacingGameApplication;
import racingcar.domain.RacingGameGenerator;
import racingcar.domain.RacingGameGeneratorImpl;
import racingcar.domain.RacingGameGeneratorProxy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameApplication racingGameApplication = new RacingGameApplication(
                initRacingGameGenerator(),
                initNumberGenerator(),
                initOutputView());
        racingGameApplication.run();
    }

    private static RacingGameGenerator initRacingGameGenerator() {
        return new RacingGameGeneratorProxy(new RacingGameGeneratorImpl(initInputView()));
    }
    private static InputView initInputView() {
        return new InputView();
    }

    private static NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }
}
