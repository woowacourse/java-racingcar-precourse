package racingcar;

import exceptions.Errors;
import exceptions.RacingException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Player {
    private List<String> names;
    private static List<Car> cars;

    public void setPlayer(Scanner scanner) {
        getNames(scanner);
        setCars(this.names);
    }

    private void getNames(Scanner scanner) {
        this.names = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        for (String name : names) {
            try {
                new Errors().nameValidation(name);
            } catch (RacingException e) {
                getNames(scanner);
            }
        }
    }

    private void setCars(List<String> names) {
        cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static List<Car> getCars() {
        return cars;
    }
}
