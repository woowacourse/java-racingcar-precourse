package racingcar.view;

import racingcar.controller.CarRaceController;
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
        showWinner();
    }

    private void getCarNames() {
        outputView.printInputCarNameMessage();
        String carNames = inputView.readInput();
        repeatIfExceptionOccur(() -> controller.inputCarName(carNames), this::getCarNames);
    }

    private void getTrial() {
        outputView.printInputTrialMessage();
        String trial = inputView.readInput();
        repeatIfExceptionOccur(() -> controller.inputTrial(trial), this::getTrial);
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
        outputView.printRaceWinner(winner);
    }

    private void repeatIfExceptionOccur(Runnable attempt, Runnable repeat) {
        try {
            attempt.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            repeat.run();
        }
    }
}
