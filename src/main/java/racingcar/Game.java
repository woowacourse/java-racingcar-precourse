package racingcar;

import ui.Input;

import java.util.Scanner;

public class Game {
    public void start(Scanner scanner) {
        String carNamesInput = Input.receiveRacingCarNames(scanner);
        String[] carNames = carNamesInput.split(",");
    }
}
