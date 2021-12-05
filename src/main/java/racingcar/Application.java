package racingcar;

import racingcar.view.Game;
import racingcar.view.classes.GameMachine;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        Game racingCarGame = new GameMachine();
        racingCarGame.start();
    }
}
