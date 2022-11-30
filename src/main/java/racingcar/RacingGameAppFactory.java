package racingcar;

import racingcar.domain.RacingGameApplication;
import racingcar.domain.RacingGameGenerator;
import racingcar.domain.RacingGameGeneratorImpl;
import racingcar.domain.RacingGameGeneratorProxy;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameAppFactory {

    private final RacingGameApplication racingGameApplication;

    public RacingGameAppFactory() {
        this.racingGameApplication = initRacingGameApplication();
    }

    public void runApp() {
        racingGameApplication.run();
    }

    private RacingGameApplication initRacingGameApplication() {
        return new RacingGameApplication(
                initRacingGameGenerator(),
                initNumberGenerator(),
                initOutputView());
    }

    private RacingGameGenerator initRacingGameGenerator() {
        return new RacingGameGeneratorProxy(new RacingGameGeneratorImpl(initInputView()));
    }

    private InputView initInputView() {
        return new InputView();
    }

    private NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }

    private OutputView initOutputView() {
        return new OutputView();
    }
}
