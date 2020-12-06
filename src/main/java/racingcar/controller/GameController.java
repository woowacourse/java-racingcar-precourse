package racingcar.controller;

import racingcar.model.GameMessage;
import racingcar.model.RacingCarGame;
import racingcar.view.GameView;
import utils.ValidationUtils;

import java.util.Scanner;

public class GameController {
    private GameView gameView;
    private RacingCarGame racingCarGame;

    public GameController(Scanner scanner) {
        gameView = new GameView(scanner);
        racingCarGame = new RacingCarGame();
    }

    private String validateCarNames(String carName) {
        while (!ValidationUtils.isValidCarNames(carName)) {
            gameView.printGameMessage(GameMessage.ERROR_INVALID_INPUT);
            carName = gameView.userInput();
        }
        return carName;
    }

    public void run() {
        gameView.printGameMessage(GameMessage.ENTER_CAR_NAMES);
        String carNames = validateCarNames(gameView.userInput());
    }
}
