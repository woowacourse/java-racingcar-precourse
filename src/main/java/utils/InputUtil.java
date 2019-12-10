package utils;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    public static List<Car> inputRacingCars() {
        String[] carNames =
                SCANNER.nextLine().trim().replace(" ", "").split(COMMA);
        List<Car> Cars = new ArrayList<>();
        for (String carName : carNames) {
            Cars.add(Car.generateCar(carName));
        }
        return Cars;
    }

    public static int inputCount() {
        return SCANNER.nextInt();
    }
}
