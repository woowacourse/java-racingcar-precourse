package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class GameSetting {
    private static final String DELIMITER = ",";
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ROUNDS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NON_INTEGER_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 정수여야 합니다.";
    private static final String NEGATIVE_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 합니다.";

    private static String[] getCarNames(Scanner scanner) {
        return scanner.nextLine().split(DELIMITER);
    }

    private static List<Car> getCarList(Scanner scanner) {
        return Arrays.stream(getCarNames(scanner))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static Cars tryToCreateCars(Scanner scanner) {
        Cars cars = new Cars(Collections.emptyList());
        try {
            System.out.println(CAR_NAME_INPUT_MESSAGE);
            cars = new Cars(getCarList(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    public static Cars createCars(Scanner scanner) {
        Cars cars;
        // try to create Cars until all Car elements have valid car names
        do {
            cars = tryToCreateCars(scanner);
        } while (cars.getNumberOfCars() == 0);
        return cars;
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
