package racingcar;

import racingcar.domain.GameManager;

public class Application {

    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.run();
    }
}
