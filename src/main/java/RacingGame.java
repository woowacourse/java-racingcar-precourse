import java.util.List;

import controller.InputController;
import controller.RaceController;
import domain.Car;

public class RacingGame {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        System.out.println("게임을 시작합니다.");
        InputController inputController = new InputController();
        List<Car> cars = inputController.getNameOfCars();
        int timesToRun = inputController.getTimesToRun();
        RaceController raceController = new RaceController(cars);
        raceController.loopThroughCars();
    }
}
