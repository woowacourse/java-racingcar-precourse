package racingcar;

import racingcar.domain.Car;
import racingcar.domain.User;
import racingcar.service.Game;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        Game game = new Game(new User());
        game.start();
    }
}
