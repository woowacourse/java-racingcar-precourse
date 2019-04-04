package racingcar;

import racingcar.utils.CarListGenerator;
import racingcar.view.InputView;

public class RacingGame {
    public void run(){
        RacingCars racingCars = new RacingCars(CarListGenerator.generate(InputView.inputCarNames()));

    }
}
