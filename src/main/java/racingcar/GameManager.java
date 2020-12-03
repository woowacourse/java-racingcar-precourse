package racingcar;

import utils.InputManager;
import utils.Sentences;

import java.util.List;
import java.util.Scanner;

public class GameManager {

    public static final int MAXIMUM_CARNAME_LENGTH = 5;

    public void gameStart(Scanner scanner) {
        InputManager inputManager = new InputManager();
        inputManager.scanCarNames(scanner);
        inputManager.scanRound(scanner);

        Round round = new Round();
    }
}
