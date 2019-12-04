package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;
import util.FormattedPrinter;

public class InputController {
    private Scanner scanner;

    public InputController() {
        this.scanner = new Scanner(System.in);
    }

    public List<Car> getNameOfCars() {
        List<Car> cars = new ArrayList<>();
        String names = FormattedPrinter.askForNames(scanner);
        //    TODO: 예외 처리
        String[] carNames = names.split(",");
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getTimesToRun() {
        int times = FormattedPrinter.askForTimes(scanner);
        return times;
    }
}
