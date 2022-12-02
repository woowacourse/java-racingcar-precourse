package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;

public class Application {
    private final GameController gameController;
    private Cars cars;
    private TryCount tryCount;

    public Application() {
        gameController = new GameController();
    }

    private void generateData() {
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
        app.generateData();
        app.race();
        app.finish();
    }
}
