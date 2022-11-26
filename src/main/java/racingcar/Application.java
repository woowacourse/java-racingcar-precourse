package racingcar;


import racingcar.domain.InputParserImpl;
import racingcar.domain.InputParserProxy;
import racingcar.domain.RacingGameApplication;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameApplication racingGameApplication = new RacingGameApplication(
                new InputParserProxy(new InputParserImpl(new InputView())),
                new OutputView());
        racingGameApplication.run();
    }
}
