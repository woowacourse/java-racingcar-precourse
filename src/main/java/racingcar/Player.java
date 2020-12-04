package racingcar;

import java.util.Scanner;

public class Player {
    private Input keyboard;
    private Cars car;

    public Player(Scanner scanner) {
        this.keyboard = new Input(scanner);
    }

    public void inputCarNames() {
        this.car = new Cars(keyboard.createCarNames());
    }

    public int inputRoundNumber() {
        return keyboard.createRoundNumber();
    }
}
