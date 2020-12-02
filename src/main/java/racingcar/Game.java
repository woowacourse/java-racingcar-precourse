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
        createPlayingCars();
    }

    private void initialize() {
    }

    private void createPlayingCars() {
        String rawCarNames = inputView.getCarNames();
    }
}
