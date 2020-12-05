package racingcar;

import java.util.Scanner;

public class GameController {
    private Scanner scanner;
    private String[] names;
    private int move;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void controlGame() {
        getInput();
        CarController carController = new CarController(names);
        while (move-- > 0) {
            carController.makeMove();
        }
    }

    private void getInput() {
        Input input = new Input(scanner);
        names = input.getCarNames();
        move = input.getMoveCount();
    }

}
