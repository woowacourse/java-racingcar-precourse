package racingcar;

import View.InputView;
import exceptions.Validator;
import exceptions.customExceptions.NotValidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingcarController {

    private static final String DELIMITER = ",";
    private final Scanner scanner;

    public RacingcarController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String inputCarName = InputView.inputCarName(scanner);
        Cars cars = new Cars(convertInputStringToCarList(inputCarName));
        int numberOfProgress = inputNumberOfProgress(scanner);
        
    }

    private List<Car> convertInputStringToCarList(String inputCarName) {
       return Arrays.stream(inputCarName.trim().split(DELIMITER))
                .filter(carName -> !carName.equals(""))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    private int inputNumberOfProgress(Scanner scanner) {
        String numberOfProgress = InputView.inputNumberOfProgress(scanner);
        Validator.validateNumberOfProgress(numberOfProgress);

        return Integer.parseInt(numberOfProgress);
    }

}
