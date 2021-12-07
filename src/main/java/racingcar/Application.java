package racingcar;

import racingcar.configuration.DependencyInjectionContainer;
import racingcar.racingsystem.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        DependencyInjectionContainer dependencyInjectionContainer = new DependencyInjectionContainer();
        RacingGame racingGame = dependencyInjectionContainer.racingGame();
        racingGame.start();
    }
}
