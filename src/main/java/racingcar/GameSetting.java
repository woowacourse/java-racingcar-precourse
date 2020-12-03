package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class GameSetting {
    // CAR NAME INPUT
    private static final int MINIMUM_NUMBER_OF_CARS_REQUIRED = 1;
    private static final String DELIMITER = ",";
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DUPLICATE_CAR_NAME_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름이 중복됩니다.";
    private static final String CAR_NAME_LENGTH_OVER_FIVE_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름은 5자 이하여야 합니다.";
    private static final String CAR_NAME_LENGTH_UNDER_ONE_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름은 1자 이상이어야 합니다.";
    private static final String NUMBER_OF_CARS_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름이 적어도 " + MINIMUM_NUMBER_OF_CARS_REQUIRED + "개 필요합니다.";

    // NUMBER OF ROUNDS INPUT
    private static final String NUMBER_OF_ROUNDS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NON_INTEGER_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 정수여야 합니다.";
    private static final String NEGATIVE_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 합니다.";

    private static void validateCarNameInput(String[] carNames) throws IllegalArgumentException{
        // at least 1 name required + names must be unique + name length less than 5
        Set<String> carNameSet = new HashSet<>();
        if (carNames.length < MINIMUM_NUMBER_OF_CARS_REQUIRED) {
            throw new IllegalArgumentException(NUMBER_OF_CARS_INPUT_ERROR_MESSAGE);
        }
        for (String carName : carNames) {
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_INPUT_ERROR_MESSAGE);
            }
            if (carName.length() < 1) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_UNDER_ONE_INPUT_ERROR_MESSAGE);
            }
            if (5 < carName.length()) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_FIVE_INPUT_ERROR_MESSAGE);
            }
            carNameSet.add(carName);
        }
    }

    private static String[] getCarNameInput(Scanner scanner) throws IllegalArgumentException {
        String[] carNames = scanner.nextLine().split(DELIMITER);
        validateCarNameInput(carNames);
        return carNames;
    }

    public static String[] getCarNames(Scanner scanner) {
        String[] carNames = null;
        boolean isValidCarNames = false;
        while (!isValidCarNames) {
            try {
                System.out.println(CAR_NAME_INPUT_MESSAGE);
                carNames = getCarNameInput(scanner);
                isValidCarNames = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNames;
    }

    public static Cars createCars(Scanner scanner) {
        List<Car> cars = Arrays.stream(getCarNames(scanner))
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static void validateNumberOfRoundsInput(String numberOfRounds) throws IllegalArgumentException {
        int numberOfRoundsCandidate;
        try {
            numberOfRoundsCandidate = Integer.parseInt(numberOfRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE);
        }
        if (numberOfRoundsCandidate < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE);
        }
    }

    private static int getNumberOfRoundsInput(Scanner scanner) throws IllegalArgumentException {
        String numberOfRounds = scanner.nextLine();
        validateNumberOfRoundsInput(numberOfRounds);
        return Integer.parseInt(numberOfRounds);
    }

    public static int getNumberOfRounds(Scanner scanner) {
        int numberOfRounds = 0;
        boolean isValidNumberOfRounds = false;
        while(!isValidNumberOfRounds) {
            try {
                System.out.println(NUMBER_OF_ROUNDS_INPUT_MESSAGE);
                numberOfRounds = getNumberOfRoundsInput(scanner);
                isValidNumberOfRounds = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return numberOfRounds;
    }
}
