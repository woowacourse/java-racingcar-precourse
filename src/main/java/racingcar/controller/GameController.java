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

    private int validateNumberOfMoves(String numberOfMoves) {
        while (!ValidationUtils.isValidNumberOfMoves(numberOfMoves)) {
            gameView.printGameMessage(GameMessage.ERROR_INVALID_INPUT);
            numberOfMoves = gameView.userInput();
        }
        return Integer.parseInt(numberOfMoves);
    }

    private void startGame(String carNames, int numberOfMoves) {
        racingCarGame.createCar(carNames);
        gameView.printGameMessage(GameMessage.NOTICE_GAME_RESULT);
        while (numberOfMoves-- > 0) {
            racingCarGame.tryToMoveCar();
            gameView.printGameResult(racingCarGame.sendResult());
        }
    }

    public void run() {
        gameView.printGameMessage(GameMessage.ENTER_CAR_NAMES);
        String carNames = validateCarNames(gameView.userInput());

        gameView.printGameMessage(GameMessage.ENTER_NUMBER_OF_MOVES);
        int numberOfMoves = validateNumberOfMoves(gameView.userInput());

        startGame(carNames, numberOfMoves);
    }
}
