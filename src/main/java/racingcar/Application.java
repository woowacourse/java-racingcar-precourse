package racingcar;

import racingcar.domain.exception.Validator;
import racingcar.view.Input;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        RacingCarGame game = new RacingCarGame(new Input(new Validator()));
        game.run();
    }
}
