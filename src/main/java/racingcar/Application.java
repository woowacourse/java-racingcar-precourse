package racingcar;


import racingcar.domain.RacingGameGeneratorImpl;
import racingcar.domain.RacingGameGeneratorProxy;
import racingcar.domain.RacingGameApplication;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameApplication racingGameApplication = new RacingGameApplication(
                new RacingGameGeneratorProxy(new RacingGameGeneratorImpl(new InputView())),
                new OutputView());
        racingGameApplication.run();
    }
}
