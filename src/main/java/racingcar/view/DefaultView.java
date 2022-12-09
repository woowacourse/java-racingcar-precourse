package racingcar.view;

import racingcar.controller.CarRaceController;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class DefaultView {

    private final OutputView outputView;
    private final InputView inputView;
    private final CarRaceController controller;

    public DefaultView(OutputView outputView, InputView inputView, CarRaceController controller) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.controller = controller;
    }

    public void render() {
        getCarNames();
        getTrial();
        showResult();
    }

    private void getCarNames() {
        outputView.printInputCarNameMessage();
        String carNames = inputView.readInput();
        controller.inputCarName(carNames);
    }

    private void getTrial() {
        outputView.printInputTrialMessage();
        String trial = inputView.readInput();
        controller.inputTrial(trial);
    }

    private void showResult() {
        outputView.printRaceResultHeader();

        while (controller.raceIsEnd()) {
            Cars cars = controller.race();
            outputView.printRaceResult(cars);
        }
    }

    private void showWinner() {
        List<String> winner = controller.getWinner();
    }
}
