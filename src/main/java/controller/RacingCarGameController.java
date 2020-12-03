package controller;

import view.InputView;
import view.OutputView;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        this.inputView.receiveNames();
    }
}
