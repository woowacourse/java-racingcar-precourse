package racingcar.game.io.error;

import static racingcar.game.io.InputCarNames.INPUT_DELIMITER;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.game.Cars;
import racingcar.game.io.error.print.CarNameInputErrorPrint;

public class CarNameInputErrorHandler {
    private static final int CAR_NAMES_MAX_COUNT = 10;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int INDEX_OF_FIRST_ELEMENT = 0;
    private static final String ALLOWED_INPUT_PATTERN = "^[a-zA-Z가-힣,]+$";

    public boolean createAndStoreIfIsValidInput(String inputStr, Cars cars) {
        if (!inputStr.contains(String.valueOf(INPUT_DELIMITER))) {
            CarNameInputErrorPrint.printMoreThanOneCarNameErrorMessage();
            return false;
        }
        if (inputStr.charAt(INDEX_OF_FIRST_ELEMENT) == INPUT_DELIMITER
            || inputStr.charAt(inputStr.length() - 1) == INPUT_DELIMITER) {
            CarNameInputErrorPrint.printCommaErrorMessage();
            return false;
        }
        if (!isOnlyAlphabetOrKorean(inputStr)) {
            CarNameInputErrorPrint.printCharErrorMessage();
            return false;
        }
        String[] carNames = splitCarNames(inputStr);
        if (!isCorrectLengthOfAllCarNames(carNames)) {
            CarNameInputErrorPrint.printCarNameLengthErrorMessage();
            return false;
        }
        if (carNames.length > CAR_NAMES_MAX_COUNT) {
            CarNameInputErrorPrint.printNumberOfCarMoreThan100ErrorMessage();
            return false;
        }
        if (isDuplicatedNames(carNames)) {
            CarNameInputErrorPrint.printDuplicateNameErrorMessage();
            return false;
        }
        createCars(carNames, cars);
        return true;
    }

    private boolean isDuplicatedNames(String[] carNames) {
        Set<String> duplicateRemovedNames = Arrays.stream(carNames).collect(Collectors.toSet());
        return carNames.length != duplicateRemovedNames.size();
    }

    private boolean isCorrectLengthOfAllCarNames(String[] carNames) {
        return Arrays.stream(carNames)
                .allMatch(carName -> CAR_NAME_MIN_LENGTH <= carName.length()
                            && carName.length() <= CAR_NAME_MAX_LENGTH);
    }

    private boolean isOnlyAlphabetOrKorean(String inputStr) {
        return Pattern.matches(ALLOWED_INPUT_PATTERN, inputStr);
    }

    private void createCars(String[] carNames, Cars cars) {
        for (String name : carNames) {
            cars.createCar(name);
        }
    }

    private String[] splitCarNames(String inputStr) {
        return inputStr.split(String.valueOf(INPUT_DELIMITER));
    }
}

