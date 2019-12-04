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

        FormattedPrinter.askForNames();
        String userInput = this.scanner.nextLine();
        //    TODO: 예외 처리
        String[] carNames = userInput.split(",");
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getTimesToRun() {
        FormattedPrinter.askForTimes();
        String userInput = this.scanner.nextLine();
        //    TODO: 예외 처리
        return Integer.parseInt(userInput);
    }
}
