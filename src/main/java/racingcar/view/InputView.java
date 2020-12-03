package racingcar.view;

import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER_COMMA = ",";

    public static List<Car> inputCarNames(Scanner scanner) {
        String carNames = scanner.nextLine();

        try {
            return Arrays.stream(carNames.split(DELIMITER_COMMA))
                    .map(String::trim)
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames(scanner);
        }
    }
}
