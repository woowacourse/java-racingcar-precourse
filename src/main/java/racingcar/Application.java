package racingcar;

import racingcar.car.CarRepository;

public class Application {
    public static void main(String[] args) {
        setUp().start();
    }

    private static RacingGameController setUp() {
        return new RacingGameController(new RacingGameService(new CarRepository()));
    }
}
