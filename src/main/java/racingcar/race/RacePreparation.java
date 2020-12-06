package racingcar.race;

import racingcar.Constant;
import racingcar.car.Car;
import racingcar.car.CarNameValidation;
import racingcar.car.ParticipatingCars;

import java.util.Scanner;
import java.util.stream.Stream;

public class RacePreparation {
    public String[] getAllCarName(Scanner scanner) {
        String input = scanner.nextLine();
        String[] allCarName = Stream.of(input.split(Constant.DELIMITER))
                .map(s -> s.replaceAll(Constant.BLANK, Constant.EMPTY_NAME))
                .toArray(String[]::new);

        CarNameValidation.validation(allCarName);

        return allCarName;
    }

    public void carRegistration(ParticipatingCars cars, String[] allCarName) {
        for (String carName : allCarName) {
            Car car = new Car(carName);
            cars.addCar(car);
        }
    }

    public int getRaceRound(Scanner scanner) {
        String number = scanner.nextLine();
        RaceRoundValidation.validation(number);

        return Integer.parseInt(number);
    }
}
