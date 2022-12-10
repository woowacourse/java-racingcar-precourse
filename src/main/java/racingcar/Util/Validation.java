package racingcar.Util;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Message.Error.*;
import static racingcar.Message.Rule.*;

public class Validation {

    public void validInputCars(String userInput) {
        checkBlank(userInput);
        checkCountOfCar(userInput);
        checkDuplicatedNames(userInput);
        for (String name : userInput.split(CAR_NAME_SEPARATOR.toString())) {
            checkNameLength(name);
        }
    }

    private void checkBlank(String userInput) {
        if (userInput.contains(BLANK.toString())) {
            throw new IllegalArgumentException(NOT_ALLOWED_BLANK_OF_NAME.toString());
        }
    }

    private void checkCountOfCar(String userInput) {
        System.out.println("userinput : " + userInput);
        if (userInput.split(CAR_NAME_SEPARATOR.toString()).length < 2) {
            throw new IllegalArgumentException(NOT_ONLY_ONE_ATTENDED.toString());
        }
    }

    private void checkNameLength(String name) {
        if (MIN_NAME_LENGTH.getConstant() > name.length() || name.length() > MAX_NAME_LENGTH.getConstant()) {
            throw new IllegalArgumentException(NOT_PROPER_NAME_LENGTH.toString());
        }
    }

    private void checkDuplicatedNames(String userInput) {
        List<String> names = new ArrayList<>();

        for (String name : userInput.split(CAR_NAME_SEPARATOR.toString())) {
            if (names.contains(name)) {
                throw new IllegalArgumentException(DUPLICATED_NAMES.toString(name));
            }

            names.add(name);
        }
    }

    public void validTryCount(String userInput) {
        isNumber(userInput);

        int count = Integer.parseInt(userInput);

        if (count < 1) {
            throw new IllegalArgumentException(NOT_NUMBER_ALLOWED_UNDER_ZERO.toString());
        }

    }

    private void isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_COUNT.toString());
        }
    }

}
