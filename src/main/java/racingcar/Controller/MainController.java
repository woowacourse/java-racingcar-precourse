package racingcar.Controller;

import racingcar.Model.RacingCarGame;
import racingcar.View.OutputView;

public class MainController {
    final RacingCarGame racingCarGame = new RacingCarGame();
    InputController inputController = new InputController();
    GameController gameController = new GameController();

    public void start() {
        setInput();
        setCars();
        play();
        printResult();
    }

    private void setInput() {
        racingCarGame.setInput(inputController.setAndGetInput());
    }

    private void setCars() {
        racingCarGame.setCars(racingCarGame.getInput());
    }

    private void play() {
        for (int i = 0; i < racingCarGame.getInput().getAttempt(); i++) {
            gameController.play(racingCarGame.getCars());
        }
    }

    private void printResult() {
        OutputView.printFinalWinner(racingCarGame.getCars());
    }
}
