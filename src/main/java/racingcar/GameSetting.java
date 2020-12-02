package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class GameSetting {
    // CAR NAME INPUT
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DUPLICATE_CAR_NAME_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름이 중복됩니다.";
    private static final String CAR_NAME_LENGTH_OVER_FIVE_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름은 5자 이하여야 합니다.";
    private static final String NUMBER_OF_CARS_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름이 2개 이상 필요합니다.";
    private static final int MINIMUM_NUMBER_OF_CARS_REQUIRED = 2;

    // NUMBER OF ROUNDS INPUT
    private static final String NUMBER_OF_ROUNDS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

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

    private static String[] getCarNameInput(Scanner scanner) throws IllegalArgumentException {
        String[] carNames = scanner.nextLine().split(",");
        checkCarNameInputValidity(carNames);
        return carNames;
    }

    private static String[] getCarNames(Scanner scanner) {
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

    private static Car createCarWithName(String carName) {
        return new Car(carName);
    }

    public static List<Car> createCars(Scanner scanner) {
        String[] carNames = getCarNames(scanner);
        return Arrays.stream(carNames)
                .map(GameSetting::createCarWithName)
                .collect(Collectors.toList());
    }
}
