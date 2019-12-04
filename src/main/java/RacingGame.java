import java.util.List;

import controller.InputController;
import controller.RaceController;
import domain.Car;

public class RacingGame {
    public static void main(String[] args) {
        play();
    }

    private static void play() {
        InputController inputController = new InputController();
        List<Car> cars = inputController.getNameOfCars();
        int timesToRun = inputController.getTimesToRun();
        RaceController raceController = new RaceController(cars);
        raceController.loopThroughCars(timesToRun);
        raceController.getWinner();
    }
}
