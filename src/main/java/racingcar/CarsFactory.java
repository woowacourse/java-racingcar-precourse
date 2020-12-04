package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsFactory {
    private static final String ERROR_EMPTY_NAME_MSG = "[ERROR] 공백 이름은 사용할 수 없습니다.";
    private static final String ERROR_ID_MAX_LENGTH_MSG = "[ERROR] 사용자의 아이디는 5글자 이하여야 합니다.";
    private static final String ERROR_ID_DUPLICATE_MSG = "[ERROR] 중복된 사용자 이름입니다.";
    private static final String ERROR_MAX_SIZE_OF_PEOPLE_MSG = "[ERROR] 인원숫자를 확인해주십시오. (2명 이상 5명 이하)";
    public static final int MIN_PEOPLE_SIZE = 2;
    public static final int MAX_PEOPLE_SIZE = 5;

    public static Cars createCars(String[] carNames) {
        validateCarNamesSize(carNames);
        validateDuplicateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            carName = carName.trim();
            validateCarNameFormat(carName);
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    private static void validateCarNameFormat(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME_MSG);
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_ID_MAX_LENGTH_MSG);
        }
    }

    private static void validateDuplicateCarNames(String[] carNames) {
        Set<String> duplicateCheckSet = new HashSet<>(Arrays.asList(carNames));
        if (duplicateCheckSet.size() != carNames.length) {
            throw new IllegalArgumentException(ERROR_ID_DUPLICATE_MSG);
        }
    }

    private static void validateCarNamesSize(String[] carNames) {
        if (carNames.length > MAX_PEOPLE_SIZE || carNames.length < MIN_PEOPLE_SIZE) {
            throw new IllegalArgumentException(ERROR_MAX_SIZE_OF_PEOPLE_MSG);
        }
    }
}
