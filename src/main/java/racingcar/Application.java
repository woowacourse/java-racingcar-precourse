package racingcar;


import racingcar.domain.RacingGameApplication;
import racingcar.domain.RacingGameApplicationProxy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameApplication racingGameApplication = new RacingGameApplication(new InputView(), new OutputView());
        RacingGameApplicationProxy racingGameApplicationProxy = new RacingGameApplicationProxy(racingGameApplication);
        racingGameApplicationProxy.run();
    }

}
