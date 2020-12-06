package racingcar.view;

import racingcar.model.GameMessage;

import java.util.Scanner;

public class GameView {
    private Scanner scanner;

    public GameView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String userInput() {
        return scanner.nextLine();
    }

    public void printGameMessage(GameMessage gameMessage) {
        System.out.print(gameMessage);
    }
}
