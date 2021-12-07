package racingcar.domain;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Condition;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    public void start() {
        InputView inputView = new InputView();
        ArrayList<Car> cars = inputView.carNameInput();
        int times = inputView.timesInput();

        OutputView outputView = new OutputView();
        outputView.showOutputStartMessage();
        for (int t = 0; t < times; t++) {
            progress(cars);
            outputView.showCurrentPosition(cars);
        }
        outputView.showWinnerCarName(cars);
    }

    private void progress(ArrayList<Car> cars) {
        cars.stream()
                .forEach(car -> car.forward(Randoms.pickNumberInRange(Condition.MIN_NUMBER, Condition.MAX_NUMBER)));
    }
}

