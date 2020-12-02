package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Car {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DUPLICATE_CAR_NAME_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름이 중복됩니다.";
    private static final String CAR_NAME_LENGTH_OVER_FIVE_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름은 5자 이하여야 합니다.";
    private static final String NUMBER_OF_CARS_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름이 2개 이상 필요합니다.";
    private static final int MINIMUM_NUMBER_OF_CARS_REQUIRED = 2;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    private static void checkCarNameInputValidity(String[] carNames) throws IllegalArgumentException{
        // at least 2 names required + names must be unique + name length less than 5
        Set<String> carNameSet = new HashSet<>();
        if (carNames.length < MINIMUM_NUMBER_OF_CARS_REQUIRED) {
            throw new IllegalArgumentException(NUMBER_OF_CARS_INPUT_ERROR_MESSAGE);
        }
        for (String carName : carNames) {
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_INPUT_ERROR_MESSAGE);
            }
            if (5 < carName.length()) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_FIVE_INPUT_ERROR_MESSAGE);
            }
            carNameSet.add(carName);
        }
    }

    private static String[] tryToGetCarNames(Scanner scanner) throws IllegalArgumentException {
        String[] carNames = scanner.nextLine().split(",");
        checkCarNameInputValidity(carNames);
        return carNames;
    }

    private static String[] getCarNames(Scanner scanner) {
        String[] carNames = null;
        boolean isValidCarNames = false;
        while (!isValidCarNames) {
            try {
                carNames = tryToGetCarNames(scanner);
                isValidCarNames = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        return carNames;
    }

    private static Car createCarWithName(String carName) {
        return new Car(carName);
    }

    public static List<Car> createCars(Scanner scanner) {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String[] carNames = getCarNames(scanner);
        return Arrays.stream(carNames)
                .map(Car::createCarWithName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return this.name;
    }
}
