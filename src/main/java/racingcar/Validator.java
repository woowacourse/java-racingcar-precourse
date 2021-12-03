package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    private static final int MINIMUM_NAME_AMOUNT = 2;
    private static final int MAXIMUM_NAME_DIGIT = 5;


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

    private void checkStartOrEndWithComma(String carNames) {
        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException(
                    ExceptionMessage.COMMA_LOCATION_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkCarNameAmount(String carNames) {
        int amount = carNames.split(",").length;
        if (amount < MINIMUM_NAME_AMOUNT) {
            throw new IllegalArgumentException(
                    ExceptionMessage.NAME_AMOUNT_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkCorrectNameDigit(String carNames) {
        List<String> names = Arrays.asList(carNames.split(","));
        for (String name : names) {
            if (name.length() > MAXIMUM_NAME_DIGIT) {
                throw new IllegalArgumentException(
                        ExceptionMessage.NAME_DIGIT_ERROR_MESSAGE.getMessage()
                );
            }
        }
    }

    private void checkDuplicateName(String carNames) {
        List<String> names = Arrays.asList(carNames.split(","));
        int removedSize = names.stream().distinct().collect(Collectors.toList()).size();
        if (names.size() != removedSize) {
            throw new IllegalArgumentException(
                    ExceptionMessage.DUPLICATED_NAME_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private void checkContainBlank(String carNames) {
        if (carNames.contains(" ")) {
            throw new IllegalArgumentException(
                    ExceptionMessage.CONTAINS_BLANK_ERROR_MESSAGE.getMessage()
            );
        }
    }

}
