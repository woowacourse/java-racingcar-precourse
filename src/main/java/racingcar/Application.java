package racingcar;

import racingcar.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        Game game = new Game(inputView);
        game.play();
    }
}
