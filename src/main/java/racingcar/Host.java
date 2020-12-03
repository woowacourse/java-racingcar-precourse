package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static racingcar.MessageBox.ATTEMPT_NUMBER_ASK_MESSAGE;
import static racingcar.MessageBox.NAME_ASK_MESSAGE;

public class Host {
    private final User user;
    private int attemptNum;
    private final Scanner sc;
    private final List<Car> cars = new ArrayList<>();

    public Host(Scanner scanner) {
        sc = scanner;
        user = new User(scanner);
    }

    public void start() {
        nameInput();
        attemptNumberInput();
        raceStart();
    }

    private void nameInput() {
        System.out.println(NAME_ASK_MESSAGE);
        String[] carNames = getCarNames();
        addCar(carNames);
    }

    private String[] getCarNames() {
        String totalCarNames = sc.nextLine().trim();
        totalCarNames = totalCarNames.replace(" ", "");
        String[] carNames = totalCarNames.split(",");
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    private void attemptNumberInput() {
        System.out.println(ATTEMPT_NUMBER_ASK_MESSAGE);
        attemptNum = getAttemptNum();
        System.out.println();
    }

    private void addCar(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void raceStart() {
        Race race = new Race(cars, attemptNum);
        race.raceStart();
    }
}
