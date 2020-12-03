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
    private static final String ALLOWED_INPUT_PATTERN = "^[a-zA-Z가-힣ㄱ-ㅎ,ㅏ-ㅣ,]+$";

    public boolean createAndStoreIfIsValidInput(String inputStr, Cars cars) {
        if (isValidInput(inputStr)) {
            return false;
        }
        String[] carNames = splitCarNames(inputStr);
        if (isAllEachCarNameValid(carNames)) {
            return false;
        }
        createCars(carNames, cars);
        return true;
    }

    private boolean isAllEachCarNameValid(String[] carNames) {
        if (!isCorrectLengthOfAllCarNames(carNames)) {
            CarNameInputErrorPrint.printCarNameLengthErrorMessage();
            return true;
        }
        if (carNames.length > CAR_NAMES_MAX_COUNT) {
            CarNameInputErrorPrint.printNumberOfCarMoreThan100ErrorMessage();
            return true;
        }
        if (isDuplicatedNames(carNames)) {
            CarNameInputErrorPrint.printDuplicateNameErrorMessage();
            return true;
        }
        return false;
    }

    private boolean isValidInput(String inputStr) {
        if (!inputStr.contains(String.valueOf(INPUT_DELIMITER))) {
            CarNameInputErrorPrint.printMoreThanOneCarNameErrorMessage();
            return true;
        }
        if (inputStr.charAt(INDEX_OF_FIRST_ELEMENT) == INPUT_DELIMITER
            || inputStr.charAt(inputStr.length() - 1) == INPUT_DELIMITER) {
            CarNameInputErrorPrint.printCommaErrorMessage();
            return true;
        }
        if (!isOnlyAlphabetOrKorean(inputStr)) {
            CarNameInputErrorPrint.printCharErrorMessage();
            return true;
        }
        return false;
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

