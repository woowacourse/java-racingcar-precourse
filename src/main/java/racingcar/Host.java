package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static racingcar.InputValidator.validateAttemptNum;
import static racingcar.InputValidator.validateCarNames;
import static racingcar.MessageBox.*;

public class Host {
    private int attemptNum;
    private final Scanner sc;
    private final List<Car> cars = new ArrayList<>();

    public Host(Scanner scanner) {
        sc = scanner;
    }

    public void start() {
        inputCarNameAndProduceCar();
        inputAttemptNum();
        raceStart();
    }

    private void inputCarNameAndProduceCar() {
        System.out.println(NAME_ASK_MESSAGE);
        String[] carNames = inputCarName();
        produceCar(carNames);
    }

    private String[] inputCarName() {
        String totalCarNames = sc.nextLine().trim();
        totalCarNames = totalCarNames.replace(" ", "");
        String[] carNames = totalCarNames.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private void produceCar(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void inputAttemptNum() {
        System.out.println(ATTEMPT_NUMBER_ASK_MESSAGE);
        String attemptNumString = sc.nextLine();
        validateAttemptNum(attemptNumString);
        attemptNum = Integer.parseInt(attemptNumString);
        System.out.println();
    }
    
    private void raceStart() {
        Race race = new Race(cars, attemptNum);
        race.raceStart();
    }
}