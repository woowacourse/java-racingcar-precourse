package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Race {
    private List<Car> allRacingCars = new ArrayList<>();

    public Race(Scanner scanner) {
        generateCars(scanner);
    }

    private void generateCars(Scanner scanner) {
        System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

        String input = scanner.nextLine();
        String[] cars = input.split(",");

        for (String carName : cars) {
            Car car = new Car(carName.trim());
            allRacingCars.add(car);
        }
    }
}
