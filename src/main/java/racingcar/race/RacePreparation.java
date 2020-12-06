package racingcar.race;

import racingcar.Constant;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class RacePreparation {
    public String[] getAllCarName(Scanner scanner) {
        String input = scanner.nextLine();

        return Stream.of(input.split(Constant.DELIMITER))
                    .map(s -> s.replaceAll(Constant.BLANK, Constant.EMPTY_NAME))
                    .toArray(String[]::new);
    }

    public List<Car> carRegistration(String[] allCarName) {
        List<Car> cars = new ArrayList<>();

        for (String carName : allCarName) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    public int getRaceRound(Scanner scanner) {
        String number = scanner.nextLine();
        RaceRoundValidation.validation(number);

        return Integer.parseInt(number);
    }
}
