package racingcar;

import racingcar.config.RacingGameAppFactory;

public class Application {
    public static void main(String[] args) {
        RacingGameAppFactory appFactory = new RacingGameAppFactory();
        appFactory.runApp();
    }
}
