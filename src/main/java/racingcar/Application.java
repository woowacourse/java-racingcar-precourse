package racingcar;

import java.util.List;

import racingcar.controller.Controller;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        List<String> carNameList = InputView.requestCarInput();
        Controller carController = Controller.of(carNameList);

        int tryCount = InputView.requestTryCount();
        carController.start(tryCount);
    }
}