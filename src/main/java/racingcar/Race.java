package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Race {
    public void play() {
        List<Car> cars = new ArrayList<>();

        for (String name : getRacePlayerNames()) {
            cars.add(new Car(name));
        }

        int RaceCount = getRaceCount();
    }

    private String[] getRacePlayerNames() {
        String input = Console.readLine();
        String[] names = input.split(", ");

        return names;
    }

    private int getRaceCount() {
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
