package racingcar;

import static racingcar.Messages.COMMA_LOCATION_ERROR_MESSAGE;
import static racingcar.Messages.CONTAINS_BLANK_ERROR_MESSAGE;
import static racingcar.Messages.DUPLICATED_NAME_ERROR_MESSAGE;
import static racingcar.Messages.NAME_AMOUNT_ERROR_MESSAGE;
import static racingcar.Messages.NAME_DIGIT_ERROR_MESSAGE;
import static racingcar.Messages.ROUND_INPUT_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    private static final int MINIMUM_NAME_AMOUNT = 2;
    private static final int MAXIMUM_NAME_DIGIT = 5;
    private static final String NUMBER_PATTERN = "\"[0-9]+\"";

    public void validateCarName(String carNames) {
        try {
            checkStartOrEndWithComma(carNames);
            checkCarNameAmount(carNames);
            checkCorrectNameDigit(carNames);
            checkDuplicateName(carNames);
            checkContainBlank(carNames);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void validateRoundNumber(String roundNumber) {
        try {
            checkContainBlank(roundNumber);
            checkNumberFormat(roundNumber);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void checkNumberFormat(String roundNumber) {
        if (!roundNumber.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(
                    ROUND_INPUT_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkStartOrEndWithComma(String carNames) {
        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException(
                    COMMA_LOCATION_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkCarNameAmount(String carNames) {
        int amount = carNames.split(",").length;
        if (amount < MINIMUM_NAME_AMOUNT) {
            throw new IllegalArgumentException(
                    NAME_AMOUNT_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkCorrectNameDigit(String carNames) {
        List<String> names = Arrays.asList(carNames.split(","));
        for (String name : names) {
            if (name.length() > MAXIMUM_NAME_DIGIT) {
                throw new IllegalArgumentException(
                        NAME_DIGIT_ERROR_MESSAGE.getMessage()
                );
            }
        }
    }

    private void checkDuplicateName(String carNames) {
        List<String> names = Arrays.asList(carNames.split(","));
        int removedSize = names.stream().distinct().collect(Collectors.toList()).size();
        if (names.size() != removedSize) {
            throw new IllegalArgumentException(
                    DUPLICATED_NAME_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkContainBlank(String carNames) {
        if (carNames.contains(" ")) {
            throw new IllegalArgumentException(
                    CONTAINS_BLANK_ERROR_MESSAGE.getMessage()
            );
        }
    }

}
