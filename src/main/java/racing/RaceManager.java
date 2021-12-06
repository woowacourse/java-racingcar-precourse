package racing;

import java.util.ArrayList;

import communicate.InputManager;
import communicate.OutputManager;

import racingcar.Car;

public class RaceManager {
    private InputManager inputManager = new InputManager();
    private OutputManager outputManager = new OutputManager();
    private ArrayList<String> carNames;
    private ArrayList<Car> cars;

    public ArrayList<Car> registerCars() {
        carNames = inputManager.provideCarNames();
        cars = new ArrayList<>();

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
}
