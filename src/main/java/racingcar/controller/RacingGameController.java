package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingGameController {


    public static void run() {
        Cars cars = new Cars(InputView.requirePlayersName());
    }
}
