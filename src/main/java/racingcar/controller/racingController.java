package racingcar.controller;

import racingcar.view.inputView;

public class racingController {

    private final inputView inputView = new inputView();

    public void start() {
        inputView.getNames();
        inputView.getRound();
    }
}
