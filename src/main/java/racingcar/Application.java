package racingcar;

import racingcar.domain.Game;
import racingcar.domain.Trial;
import racingcar.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game.run(scanner);
    }
}
