package racingcar.game.io.error;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarNameInputErrorHandler {


    public boolean isValidInput(String inputStr) {
        if (!inputStr.contains(",")) {
            CarNameInputErrorPrint.printMoreThanOneCarNameErrorMessage();
            return false;
        }
        if (inputStr.charAt(0) == ',' || inputStr.charAt(inputStr.length() - 1) == ',') {
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
        if (carNames.length > 100) {
            CarNameInputErrorPrint.printNumberOfCarMoreThan100ErrorMessage();
            return false;
        }
        if (isDuplicatedNames(carNames)) {
            CarNameInputErrorPrint.printDuplicateNameErrorMessage();
            return false;
        }
        createCars(carNames);
        return true;
    }

    private boolean isDuplicatedNames(String[] carNames) {
        Set<String> duplicateRemovedNames = Arrays.stream(carNames).collect(Collectors.toSet());
        return carNames.length != duplicateRemovedNames.size();
    }

    private boolean isCorrectLengthOfAllCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!(1 <= carName.length() && carName.length() <= 5)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOnlyAlphabetOrKorean(String inputStr) {
        String pattern = "^[a-zA-Z가-힣,]+$";
        return Pattern.matches(pattern, inputStr);
    }
}

