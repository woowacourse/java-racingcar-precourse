package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Race {
    private final InputValidator inputValidator = new InputValidator();

    public void play() {
        List<Car> cars = new ArrayList<>();

        for (String name : getCarNames()) {
            cars.add(new Car(name));
        }

        int raceCount = getTryCount();

        Game game = new Game(cars, raceCount);

        game.play();
    }

    private String[] getCarNames() {
        String input = Console.readLine();
        String[] names = input.split(",");

        try {
            inputValidator.validateCarNamesInput(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }

        return names;
    }

    private int getTryCount() {
        String input = Console.readLine();

        try {
            inputValidator.validateTryCount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }

        return Integer.parseInt(input);
    }
}
