package racingcar.game;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserInputCarNames {
    private final Cars cars;
    private final UserCarNameInputErrorHandler errorHandler;

    public UserInputCarNames() {
        this.cars = new Cars();
        this.errorHandler = new UserCarNameInputErrorHandler();
    }

    public Cars getInputFromUser(Scanner scanner) {
        String inputStr;
        do {
            InputPrint.printMessageForInputCarNames();
            inputStr = getInputCarNames(scanner);
        } while (!isValidInput(inputStr));
        return cars;
    }

    private boolean isValidInput(String inputStr) {
        if (!inputStr.contains(",")) {
            errorHandler.printMoreThanOneCarNameErrorMessage();
            return false;
        }
        if (inputStr.charAt(0) == ',' || inputStr.charAt(inputStr.length() - 1) == ',') {
            errorHandler.printCommaErrorMessage();
            return false;
        }
        if (!isOnlyAlphabetOrKorean(inputStr)) {
            errorHandler.printCharErrorMessage();
            return false;
        }
        String[] carNames = splitCarNames(inputStr);
        if (!isCorrectLengthOfAllCarNames(carNames)) {
            errorHandler.printCarNameLengthErrorMessage();
            return false;
        }
        if (carNames.length > 100) {
            errorHandler.printNumberOfCarMoreThan100ErrorMessage();
            return false;
        }
        if (isDuplicatedNames(carNames)) {
            errorHandler.printDuplicateNameErrorMessage();
            return false;
        }
        createCars(carNames);
        return true;
    }

    private void createCars(String[] carNames) {
        for (String name : carNames) {
            cars.createCar(name);
        }
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

    private String[] splitCarNames(String inputStr) {
        return inputStr.split(",");
    }

    private boolean isOnlyAlphabetOrKorean(String inputStr) {
        String pattern = "^[a-zA-Z가-힣,]+$";
        return Pattern.matches(pattern, inputStr);
    }

    private String getInputCarNames(Scanner scanner) {
        return scanner.nextLine();
    }
}
