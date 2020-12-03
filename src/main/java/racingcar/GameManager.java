package racingcar;

import utils.InputManager;
import utils.Sentences;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    public static final int MAXIMUM_CARNAME_LENGTH = 5;

    public void startGame(Scanner scanner) {
        InputManager inputManager = new InputManager();
        ArrayList<Car> cars = new ArrayList<>(inputManager.scanCarNames(scanner));
        Round round = new Round(inputManager.scanRound(scanner));
        System.out.println(Sentences.SHOW_RESULT);
    }

    public void startRace(ArrayList<Car> cars) {


    }
}
