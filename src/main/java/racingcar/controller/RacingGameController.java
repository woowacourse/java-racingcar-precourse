package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingGameController {


    public static void run() {
        prepareCars();

    }

    private static void prepareCars() {
        try {
            Cars cars = new Cars(InputView.requirePlayersName());
        } catch (IllegalArgumentException exception) {
            prepareCars();
        }
    }
}
