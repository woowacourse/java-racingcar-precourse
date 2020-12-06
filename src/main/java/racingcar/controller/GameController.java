package racingcar.controller;

import racingcar.model.GameMessage;
import racingcar.model.RacingCarGame;
import racingcar.view.GameView;

import java.util.Scanner;

public class GameController {
    private GameView gameView;
    private RacingCarGame racingCarGame;

    public GameController(Scanner scanner) {
        gameView = new GameView(scanner);
        racingCarGame = new RacingCarGame();
    }

    public void run() {
        gameView.printGameMessage(GameMessage.ENTER_CAR_NAMES);
    }
}
