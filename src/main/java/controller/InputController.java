package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;
import util.InputOutputHandler;

public class InputController {
    private Scanner scanner;

    public InputController() {
        this.scanner = new Scanner(System.in);
    }

    public List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();
        String[] names = InputOutputHandler.askForNames(scanner);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int generateTimes() {
        return InputOutputHandler.askForTimes(scanner);
    }
}
