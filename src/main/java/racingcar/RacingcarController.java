package racingcar;

import View.InputView;
import View.OutputView;
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
        InputView inputView = new InputView(scanner);

        try {
            String inputCarName = inputView.inputCarName();
            cars = new Cars(convertInputStringToCarList(inputCarName));
            int numberOfProgress = inputView.inputNumberOfProgress();

            startRacing(numberOfProgress);
        } catch (NotValidInputException e) {
            e.printStackTrace();
        }
    }

    private void startRacing(int numberOfProgress) {
        OutputView.printProgressResultMessage();
        for (int i = 0; i < numberOfProgress; i++) {
            cars.progressTurn();
            cars.showCurrentStatus();
        }
        OutputView.printWinners(cars.findWinners());
    }

    private List<Car> convertInputStringToCarList(String inputCarName) {
        return Arrays.stream(inputCarName.trim().split(DELIMITER))
                .filter(carName -> !carName.equals(""))
                .map(carName -> new Car(carName.trim()))
                .collect(Collectors.toList());
    }

}
