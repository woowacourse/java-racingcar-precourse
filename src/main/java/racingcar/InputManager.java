package racingcar;
/*
 * InputManager
 *
 * version 1.0
 *
 * 2020.12.05
 *
 * Copyright (c) by Davinci.J
 */
import java.util.*;

public class InputManager {
    private static final IllegalArgumentException CAR_INPUT_ERROR = new IllegalArgumentException(
                                                                        Constants.CAR_ERROR_STATEMENT);
    private static final IllegalArgumentException COUNT_INPUT_ERROR = new IllegalArgumentException(
                                                                        Constants.COUNT_ERROR_STATEMENT);

    private Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Car> generateCars() throws IllegalArgumentException {
        String carList = scanner.next();
        Set<Car> filteredCars = new LinkedHashSet<>();
        String[] preFilteredCars = carList.split(Constants.SEPARATOR);
        for (String preFilteredCar : preFilteredCars) {
            if (preFilteredCar.length() > Constants.NAME_MAX_LENGTH) {
                throw CAR_INPUT_ERROR;
            }
            filteredCars.add(new Car(preFilteredCar));
        }
        if (preFilteredCars.length != filteredCars.size()) {
            throw CAR_INPUT_ERROR;
        }
        return new ArrayList<>(filteredCars);
    }

    public int inputTrialCount() throws IllegalArgumentException{
        System.out.println(Constants.COUNT_INPUT_STATEMENT);
        String trialCount = scanner.next();
        for (int i=0; i<trialCount.length(); i++) {
            if (trialCount.charAt(i) - '0' > Constants.SINGLE_DIGIT_MAX
                    || trialCount.charAt(i) - '0' < Constants.SINGLE_DIGIT_MIN) {
                throw COUNT_INPUT_ERROR;
            }
        }
        System.out.println();
        return Integer.parseInt(trialCount);
    }
}