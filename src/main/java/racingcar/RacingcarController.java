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
    private Cars cars;

    public RacingcarController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String inputCarName = InputView.inputCarName(scanner);
        cars = new Cars(convertInputStringToCarList(inputCarName));
        int numberOfProgress = inputNumberOfProgress(scanner);
        playGame(numberOfProgress);
    }

    private void playGame(int numberOfProgress) {
        for (int i = 0; i < numberOfProgress; i++) {
            cars.progressTurn();
            cars.showCurrentStatus();
        }
    }

    private List<Car> convertInputStringToCarList(String inputCarName) {
        return Arrays.stream(inputCarName.trim().split(DELIMITER))
                .filter(carName -> !carName.equals(""))
                .map(carName -> new Car(carName.trim()))
                .collect(Collectors.toList());
    }

    private int inputNumberOfProgress(Scanner scanner) {
        String numberOfProgress = InputView.inputNumberOfProgress(scanner);
        Validator.validateNumberOfProgress(numberOfProgress);

        return Integer.parseInt(numberOfProgress);
    }

}
