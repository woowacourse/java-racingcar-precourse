package racingcar;

import utils.InputManager;
import utils.Sentences;

import java.util.List;
import java.util.Scanner;

public class GameManager {

    public static final int MAXIMUM_CARNAME_LENGTH = 5;

    public void gameStart(Scanner scanner) {
        InputManager.scanCarNames(scanner);
        InputManager.scanRound(scanner);

        Round round = new Round();
    }
}
