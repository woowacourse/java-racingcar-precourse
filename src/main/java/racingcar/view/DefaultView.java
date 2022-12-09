package racingcar.view;

import racingcar.controller.CarRaceController;

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
    }

    private void getCarNames() {
        outputView.printInputCarNameMessage();
        String carNames = inputView.readInput();
        controller.inputCarName(carNames);
    }

    private void getTrial() {
        outputView.printInputTrialMessage();
        String trial = inputView.readInput();
    }
}
