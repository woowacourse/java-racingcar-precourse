package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Race {
    public void play() {
        List<Car> cars = new ArrayList<>();

        for (String name : getRacePlayerNames()) {
            cars.add(new Car(name));
        }
    }

    private String[] getRacePlayerNames() {
        String input = Console.readLine();
        String[] names = input.split(", ");

        return names;
    }
}
