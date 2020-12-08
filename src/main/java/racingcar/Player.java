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
        setNames(scanner);
        setCars(this.names);
    }

    private void setNames(Scanner scanner) {
        final Errors errors = new Errors();

        String input = scanner.nextLine();
        this.names = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        for (String name : names) {
            try {
                errors.playerNumberValidation(names);
                errors.nameValidation(name);
                errors.nameDuplication(names, name);
            } catch (RacingException e) {
                setNames(scanner);
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
