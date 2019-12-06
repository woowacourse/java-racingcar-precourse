package ui;

import domain.Car;
import domain.RacingCar;
import domain.RacingGameConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console implements UserInterface {

    private Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<RacingCar> extractRacingCars() {
        //todo: check dependency
        String input = scanner.nextLine();
        String[] names = parseNames(input);
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(new Car(name));
        }

        return racingCars;
    }

    private String[] parseNames(String input) {
        return input.split(RacingGameConfig.STANDARD_TO_PARSE);
    }

    @Override
    public int getCycles() {
        return 0;
    }
}
