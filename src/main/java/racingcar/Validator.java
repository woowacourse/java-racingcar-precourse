package racingcar;

import static racingcar.Messages.COMMA_LOCATION_ERROR_MESSAGE;
import static racingcar.Messages.CONTAINS_BLANK_ERROR_MESSAGE;
import static racingcar.Messages.DUPLICATED_NAME_ERROR_MESSAGE;
import static racingcar.Messages.NAME_AMOUNT_ERROR_MESSAGE;
import static racingcar.Messages.NAME_DIGIT_ERROR_MESSAGE;
import static racingcar.Messages.ROUND_INPUT_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;

public class Validator {

    private static final int MINIMUM_NAME_AMOUNT = 2;
    private static final int MAXIMUM_NAME_DIGIT = 5;
    private static final String COMMA = ",";

    public void validateCarName(String carNames) throws IllegalArgumentException {
        checkStartOrEndWithComma(carNames);
        checkCarNameAmount(carNames);
        checkCorrectNameDigit(carNames);
        checkDuplicateName(carNames);
        checkContainBlank(carNames);
    }

    public void validateRoundNumber(String roundNumber) throws IllegalArgumentException {
        checkContainBlank(roundNumber);
        checkNumberFormat(roundNumber);
    }

    private void checkNumberFormat(String roundNumber) {
        for (int i = 0; i < roundNumber.length(); i++) {
            if (!Character.isDigit(roundNumber.charAt(i))) {
                throw new IllegalArgumentException(
                        ROUND_INPUT_ERROR_MESSAGE.getMessage()
                );
            }
        }

    }

    private void checkStartOrEndWithComma(String carNames) {
        if (carNames.startsWith(COMMA) || carNames.endsWith(COMMA)) {
            throw new IllegalArgumentException(
                    COMMA_LOCATION_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkCarNameAmount(String carNames) {
        int amount = carNames.split(COMMA).length;
        if (amount < MINIMUM_NAME_AMOUNT) {
            throw new IllegalArgumentException(
                    NAME_AMOUNT_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkCorrectNameDigit(String carNames) {
        String[] names = carNames.split(COMMA);
        for (String name : names) {
            if (name.length() > MAXIMUM_NAME_DIGIT) {
                throw new IllegalArgumentException(
                        NAME_DIGIT_ERROR_MESSAGE.getMessage()
                );
            }
        }
    }

    private void checkDuplicateName(String carNames) {
        List<String> names = Arrays.asList(carNames.split(COMMA));
        int removedSize = (int) names.stream().distinct().count();
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
