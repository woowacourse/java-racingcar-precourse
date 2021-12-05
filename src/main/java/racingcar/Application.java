package racingcar;

import racingcar.console.ConsoleCarInitializer;
import racingcar.console.ConsoleMovementGenerator;

public class Application {
    public static void main(String[] args) {
        new CarGame(new ConsoleCarInitializer(), new ConsoleMovementGenerator()).run();
    }
}
