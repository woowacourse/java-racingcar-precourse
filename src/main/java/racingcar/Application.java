package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.Cars;

public class Application {
    private final GameController gameController;
    private Cars cars;
    private Long tryCount;

    public Application() {
        gameController = new GameController();
    }

    private void readData() {
        String[] names = gameController.readNames();
        this.cars = gameController.createCars(names);
        Long tryCount = gameController.readTryCount();
        this.tryCount = gameController.createTryCount(tryCount);
    }

    private void race() {
        gameController.race(cars, tryCount);
    }

    private void finish() {
        gameController.finish(cars);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.readData();
        app.race();
        app.finish();
    }
}
