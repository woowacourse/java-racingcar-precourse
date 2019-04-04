package racingcar;

import racingcar.utils.CarListGenerator;
import racingcar.view.InputView;

public class RacingGame {
    public void run(){
        CarListGenerator.generate(InputView.inputCarNames());

    }
}
