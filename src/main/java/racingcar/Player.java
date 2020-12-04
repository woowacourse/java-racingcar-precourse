package racingcar;

import java.util.Scanner;

public class Player {
    private Input keyboard;
    private Cars cars;

    public Player(Scanner scanner) {
        this.keyboard = new Input(scanner);
    }

    public void inputCarNames() {
        this.cars = new Cars(keyboard.createCarNames());
    }

    public int inputRoundNumber() {
        return keyboard.createRoundNumber();
    }

    public void moveCars() {
        cars.moveByRandomNumber();
    }
}
