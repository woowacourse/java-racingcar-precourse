package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;

public class RacingController {
    private static final InputView inputView = new InputView();

    public void run() {
        enrollCarToRace();
    }

    public void enrollCarToRace() {
        List<String> carNames = inputView.inputCarNames();
        System.out.println(carNames);
    }
}
