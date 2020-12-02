package racingcar;

import view.InputView;

public class Game {
    public static final String NAME_SEPARATOR = ",";

    private final InputView inputView;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        initialize();
        String carNames = inputView.getCarNames();
        System.out.println(carNames);
    }

    private void initialize() {

    }
}
