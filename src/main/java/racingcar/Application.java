package racingcar;

import racingcar.car.RandomMovingPolicy;
import racingcar.game.GameMachine;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine(new RandomMovingPolicy(), new InputView());
        gameMachine.run();
    }
}
