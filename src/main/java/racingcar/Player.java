package racingcar;

import exceptions.Errors;
import exceptions.RacingException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Player {
    private List<String> names;
    private List<Car> cars;

    public Player(Scanner scanner) {
        setPlayer(scanner);
    }

    public void setPlayer(Scanner scanner) {
        getNames(scanner);
        setCars(this.names);
    }

    public void getNames(Scanner scanner) {
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

    public void setCars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
