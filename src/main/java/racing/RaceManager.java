package racing;

import java.util.ArrayList;
import java.util.Collections;

import communicate.InputManager;
import communicate.OutputManager;

import racingcar.Car;

public class RaceManager {
    private static final int ZERO = 0;
    private final InputManager inputManager = new InputManager();
    private final OutputManager outputManager = new OutputManager();
    private ArrayList<Car> cars;
    private ArrayList<Car> winners;

    public RaceManager() {
        cars = new ArrayList<>();
        winners = new ArrayList<>();
    }

    public ArrayList<Car> registerCars() {
        ArrayList<String> carNames = inputManager.provideCarNames();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int assignAttemptNumber() {
        return inputManager.provideAttemptNumber();
    }

    public void showOneSetResult() {

        for (Car car : cars) {
            outputManager.printCarsInformation(car);
        }

        System.out.println();
    }

    private void judgeWinner() {
        Collections.sort(cars);
        winners.add(cars.get(ZERO));

        for (int i = 1; i < cars.size(); i++) {

            if (winners.get(ZERO).compareTo(cars.get(i)) == ZERO) {
                winners.add(cars.get(i));
                continue;
            }

            break;
        }

    }

    public void announceWinner() {
        judgeWinner();
        outputManager.printWinner(winners);
    }
}
