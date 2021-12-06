package racingcar.domain;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    public void start() {
        InputView inputView = new InputView();
        ArrayList<Car> cars = inputView.inputCarName();
        int times = inputView.inputTimes();

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
                .forEach(car -> car.forward(Randoms.pickNumberInRange(0, 9)));
    }
}

