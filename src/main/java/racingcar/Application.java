package racingcar;

import java.util.Scanner;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        Game racingCarGame = new Game(inputView);

        racingCarGame.play();
    }
}
