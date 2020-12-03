package racingcar;

import View.InputView;
import exceptions.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingcarController {

    private static final String DELIMITER = ",";
    private final Scanner scanner;
    List<Car> cars;

    public RacingcarController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        cars = Arrays.stream(InputView.inputCarName(scanner).trim().split(DELIMITER))
                .filter(carName -> !carName.equals(""))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
        Validator.validateCarsSize(cars);
    }

}
